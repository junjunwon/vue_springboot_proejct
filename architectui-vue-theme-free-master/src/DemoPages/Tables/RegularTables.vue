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
    <b-card title="" class="main-card mb-4">
        <b-table 
                 :striped="striped"
                 :bordered="bordered"
                 :outlined="outlined"
                 :small="small"
                 :hover="hover"
                 :dark="dark"
                 :fixed="fixed"
                 :foot-clone="footClone"
                 :items="items"
                 :fields="fields"
                 >
        </b-table>
        <br />
        <b-pagination-nav size="mg" align="fill" base-url="#" :number-of-pages="100" v-model="currentPage" :per-page="100"/>
    </b-card>
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
      heading: '데스크탑 접속이력',
      // subheading: 'Tables are the backbone of almost all web applications.',
      icon: 'pe-7s-drawer icon-gradient bg-happy-itmeo',

      fields: [ 'content', 'id', 'moddate','moduser','regdate','reguser','title' ],
      items: [
        // { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        // { age: 89, first_name: 'Geneva', last_name: 'Wilson' }
      ],
      item : null,
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
        this.$axios.get('/api/boards')
        .then((response) =>{
          this.items = response.data.data;
        })
        .catch(error=>{
          console.log("cannot found datas"+error);
        })
      }
    }
  }
</script>
