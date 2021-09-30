<template>
  <div>
    <page-title :heading=heading :subheading=subheading :icon=icon></page-title>

    <div class="content">
        <b-row>
          <b-col md="12">
            <b-card class="mb-3" no-body>
              <b-tabs pills card>
                <b-tab title="공지사항" active>
                  <b-input-group prepend="조회" class="mt-3">
                    <b-form-input></b-form-input>
                    <b-input-group-append>
                      <b-button variant="outline-success" class="pe-7s-search"></b-button>
                      <div class="btn-space" />
                      <b-button variant="info" @click="writeNotice">글 작성</b-button>
                    </b-input-group-append>
                  </b-input-group>
                  <b-card title="" class="main-card mb-4">
                      <b-table 
                      :items="noticeList"
                      :fields="noticeField"
                      :striped="striped"
                      :bordered="bordered"
                      :outlined="outlined"
                      :small="small"
                      :hover="hover"
                      :dark="dark"
                      :fixed="fixed"
                      :foot-clone="footClone">
                      </b-table>
                      <br />
                      <b-pagination-nav size="mg" align="fill" base-url="#" :number-of-pages="100" v-model="currentPage" :per-page="100"/>
                  </b-card>
                </b-tab>
                <b-tab title="FAQ">
                </b-tab>
                <b-tab title="자료실">
                </b-tab>
                <b-tab title="QNA">
                
                </b-tab>
                <b-tab title="오류보고">
                 
                </b-tab>
                <b-tab title="OTP">
                 
                </b-tab>
              </b-tabs>
            </b-card>
          </b-col>
        </b-row>
    </div>
  </div>
</template>

<script>

  import PageTitle from "../../Layout/Components/PageTitle.vue";

  export default {
    components: {
      PageTitle,

    },
    created() {
      this.fetchData();
    },
    data: () => ({
      heading: '게시판',
      subheading: '',
      icon: 'pe-7s-drawer icon-gradient bg-happy-itmeo',
      noticeList:[],
      noticeField:['noticeId', 'title', 'contents','wrtierId', 'createDate', 'updateDate'],
      item:null,
      striped: true,
      bordered: true,
      outlined: true,
      small: false,
      hover: false,
      dark: false,
      fixed: false,
      footClone: false
    }),
    methods: {
      fetchData : function(){
        this.$axios.get("/api/notices")
        .then((response)=>{
          this.noticeList = response.data.data;
        })
        .catch((ex)=>{
          console.error("cannot found the list"+ex);
        })
      },
      writeNotice : function(){
        this.$router.push('/forms/boardnotice')
      }
    },

  }
</script>
