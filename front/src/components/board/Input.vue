<template>
    <div id="app">
        <h1>Board</h1>
        <div class="container">
            <input type="hidden" v-model="board.id">
            <div class="forn-group">
                <p>제목</p>
                <input type="text" class="form-control" v-model="board.title"/>
            </div>
            <div class="form-group">
                <p>내용</p>
                <textarea class="form-control" v-model="board.content" rows="10"></textarea>
            </div>
            <div class="form-group">
                <button @click="save">저장</button>
                <button @click="$router.back()">돌아가기</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name : "BoardInfo",
    data() {
        return {
            board : {
                message : '',
                id : '',
                title : '',
                content : ''
            }
        }
    },
    methods: {
        save : function(){
            this.$axios.post('/api/boards/post', this.board)
            .then(() => {
                this.$router.push('/board')
            })
            .catch((ex) => {
                console.error("failed write article", ex)
            })
        }
    },
}
</script>