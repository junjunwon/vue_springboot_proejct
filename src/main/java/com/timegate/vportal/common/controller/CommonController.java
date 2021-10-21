package com.timegate.vportal.common.controller;

import com.timegate.vportal.common.utils.MessageLogger;
import com.timegate.vportal.common.utils.RSAUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

@Controller
public class CommonController {

    MessageLogger logger = new MessageLogger();

    //@RequestMapping(value="/api/auth/getPairKey", method={RequestMethod.GET, RequestMethod.POST}, headers = "Accept=application/json")
    @PostMapping(value="/api/auth/getPairKey", headers = "Accept=application/json")
    public ResponseEntity<Map<String, String>> getPairKey(HttpServletRequest request, HttpServletResponse response)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException
            , UnsupportedEncodingException, BadPaddingException, InvalidKeyException {
        logger.infoLog(new Object(){}, "/api/auth/getPairKey");

        // 세션에 남아있을지도 몰라서 생성 전에 제거
        request.getSession().removeAttribute(RSAUtils.PRIVATE_KEY);
        // Key 생성
        KeyPair keys = RSAUtils.genKey();
        PublicKey publicKey = keys.getPublic();
        PrivateKey privateKey = keys.getPrivate();

        // 개인키는 세션에 저장
        request.getSession().setAttribute(RSAUtils.PRIVATE_KEY, privateKey);
        // 클라이언트 공개키 생성을 위한 파라미터
        Map<String, String> spec = RSAUtils.getKeySpec(publicKey);
        /*request로 value가 return이 안됨*/
        request.setAttribute(RSAUtils.PUBLIC_KEY_MODULUS, spec.get(RSAUtils.PUBLIC_KEY_MODULUS));
        request.setAttribute(RSAUtils.PUBLIC_KEY_EXPONENT, spec.get(RSAUtils.PUBLIC_KEY_EXPONENT));
        //request.setAttribute(RSAUtil.PUBLIC_KEY, keys.getPublic()); // 사용X

        logger.debugLog(new Object(){}, RSAUtils.PRIVATE_KEY + ":" + (PrivateKey) request.getSession().getAttribute(RSAUtils.PRIVATE_KEY));
        logger.debugLog(new Object(){}, RSAUtils.PUBLIC_KEY_MODULUS + ":" + spec.get(RSAUtils.PUBLIC_KEY_MODULUS));
        logger.debugLog(new Object(){}, RSAUtils.PUBLIC_KEY_EXPONENT + ":" + spec.get(RSAUtils.PUBLIC_KEY_EXPONENT));

        return ResponseEntity.ok(spec);
    }
}