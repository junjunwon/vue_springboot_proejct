<template>
    <div>
        <page-title :heading=heading :subheading=subheading :icon=icon></page-title>
        <div class="row">
            <div class="col-md-12">
                <div class="main-card mb-3 card">
                    <div class="card-body"><h5 class="card-title">글 작성</h5>
                        <form class="">
                            <div class="position-relative form-group"><label for="title"
                                                                             class="">글 제목</label><input name="title"
                                                                                                          id="title"
                                                                                                          placeholder="제목을 입력해주세요."
                                                                                                          class="form-control">
                            </div>
                            <div class="position-relative form-group"><label for="content" class="">글 내용</label><textarea name="content" id="content" class="form-control"></textarea>
                            </div>
                            <div class="position-relative form-group"><label for="exampleFile"
                                                                             class="">File</label><input name="file"
                                                                                                         id="exampleFile"
                                                                                                         type="file"
                                                                                                         class="form-control-file">
                                <small class="form-text text-muted">This is some placeholder block-level help text for
                                    the above input. It's a bit lighter and easily wraps to a new line.
                                </small>
                            </div>
                            <button style="margin-right:10px" class="mt-1 btn btn-primary">저장</button>
                            <button class="mt-1 btn btn-primary">닫기</button>
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
                title : '',
                content : ''
            },
        }
    },
    methods: {
        save : function(){
            this.$axios.post("/api/")
        }
    },
}
</script>