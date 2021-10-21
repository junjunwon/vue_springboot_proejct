const path = require('path');

module.exports = {
    outputDir : "../src/main/resources/static",
    devServer : {
        port : 3030,
        proxy : {
            '/' : {
                target : 'http://localhost:3000',
                ws : true,
                changeOrigin : true
            }
        }
    },
    configureWebpack:{
        resolve : {
            alias : {
                'BOARD' : path.join(__dirname, 'src/components/board') //자주쓰는 경로를 BOARD로 묶어 가독성을 높인다.
            }
        }
    }
}