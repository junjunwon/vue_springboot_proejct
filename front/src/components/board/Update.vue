<template>
    <div id="app">
        <h1>Board Update</h1>
        <div class="container">
            <input type="hidden" v-model="board.id"/>
            <div class="form-group">
                <p>제목</p>
                <input type="text" class="form-control" v-model="board.title" />
            </div>
            <div class="form-group">
                <p>내용</p>
                <textarea class="form-control" v-model="board.content" rows="10"></textarea>
            </div>
            <div class="form-group">
                <button @click="update">수정</button>
                <button @click="$router.back()">돌아가기</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name : "BoardInfo",
    created() {
        this.fetchBoard()
    },
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
        fetchBoard : function(){
            let pid = this.$route.query.id;
            if(!pid) return;
            this.$axios.get('/api/boards/'+pid)
            .then((response)=>{
                this.board=response.data;
            })
            .catch((error)=>{
                console.error("not found board : ", error);
            })
        },
        update : function (){
            this.$axios.put('/api/boards/update/'+this.board.id, this.board)
            .then(()=>{
                this.$router.push('/board')
            })
            .cathc((ex)=>{
                console.error("failed write article", ex);
            })
        }
    },
}
</script>