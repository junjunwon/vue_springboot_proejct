<template>
    <div>
        <page-title :heading=heading :icon=icon></page-title>
        <b-input-group prepend="조회" class="mt-3">
            <b-form-input></b-form-input>
            <b-input-group-append>
                <b-button variant="outline-success" class="pe-7s-search"></b-button>
                <div class="btn-space" />
                <b-button variant="info">엑셀 다운</b-button>
                <div class="btn-space" />
                <b-button variant="info">컬럼 설정 저장</b-button>
            </b-input-group-append>
        </b-input-group>
        <br />
        <div class="main-card mb-3 card">
            <div class="card-body">
                <div class="font-icon-wrapper font-icon-lg">
                    <i class="pe-7s-users icon-gradient bg-warm-flame"> </i>
                    <b-dropdown no-flip :text="''" class="mb-2 mr-2" :variant="'outline-link'" :key="'outline-link'">
                        <button type="button" tabindex="0" class="dropdown-item">계정 잠금</button>
                        <button type="button" tabindex="-1" class="dropdown-item">계정 잠금 해제</button>
                        <button type="button" tabindex="-1" class="dropdown-item">관리자 계정 삭제</button>
<!--                        <h6 tabindex="-1" class="dropdown-header">Header</h6>-->
                        <div tabindex="-1" class="dropdown-divider"></div>
                        <button type="button" tabindex="0" class="dropdown-item">관리자 메뉴 관리</button>
                        <button type="button" tabindex="0" class="dropdown-item">관리자 상단 알람 설정</button>
                        <button type="button" tabindex="0" class="dropdown-item">관리자 메뉴 템플릿</button>
                    </b-dropdown>
                </div>
            </div>
        </div>
    </div>

</template>

<script>

import PageTitle from "@/Layout/Components/PageTitle";

export default{
    components : {
      PageTitle
    },
    data() {
        return {
            heading:'관리자 계정 관리'

        }
    }
}
</script>