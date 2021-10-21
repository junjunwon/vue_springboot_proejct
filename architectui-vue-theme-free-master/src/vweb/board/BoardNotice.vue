<template>
    <div>
        <page-title :heading=heading :subheading=subheading :icon=icon></page-title>
        <div class="row">
            <div class="col-md-12">
                <div class="main-card mb-3 card">
                    <div class="card-body"><h5 class="card-title">글 작성</h5>
                        <form v-on:submit.prevent class="">
                            <div class="position-relative form-group"><label for="title"
                                                                             class="">글 제목</label><input name="title"
                                                                                                          id="title"
                                                                                                          placeholder="제목을 입력해주세요."
                                                                                                          class="form-control" v-model="notice.title">
                            </div>
                            <div class="position-relative form-group"><label for="content" class="">글 내용</label><textarea name="content" id="content" class="form-control" v-model="notice.contents"></textarea>
                            </div>
                            <div class="position-relative form-group"><label for="exampleFile"
                                                                             class="">File</label><input name="file"
                                                                                                         id="exampleFile"
                                                                                                         type="file"
                                                                                                         class="form-control-file">
                            </div>
                            <button @click="save" style="margin-right:10px" class="mt-1 btn btn-primary">저장</button>
                            <button @click="$router.go(-1)" class="mt-1 btn btn-primary">닫기</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            notice : {
                noticeId : '',
                title : '',
                contents : ''
            },
        }
    },
    methods: {
        save : function(){
            this.$axios.post('/api/notices/save', this.notice)
            .then(() => {
                alert("abc")
                console.log("뭐야 이거 ")
                this.$router.push('/board/vweb_board_mgmt')
            })
            .catch((ex)=>{
                console.error("failed write article", ex)
            })
        }
    },
}
</script>