<template>
  <div>
    <div class="search">
      <el-input v-model="illness_name" placeholder="请输入疾病名" />
      <el-button @click="reset">重置</el-button>
      <el-button @click="get_seq_comp">确认</el-button>
    </div>
    <!--    <li>{{items}}<li/>-->
    <vue-good-table
      :columns="columns"
      :rows="rows"
      max-height="300px"
      :line-numbers="true"
    >
    </vue-good-table>

  </div>
</template>

<script>

import { query_seq_comp } from "@/api/analysis/analysis.js";
import { VueGoodTable } from 'vue-good-table';
import 'vue-good-table/dist/vue-good-table.css'

export default {
    data() {
      return {
        columns: [
          {
            label: 'illness_id',
            field: 'illness_id',
            type:'int',
          },
          {
            label: 'illness_name',
            field: 'illness_name',
            type:'string'
          },
        ],
        rows: [],
        illness_name: "",
      };
    },
    components: {
      VueGoodTable,
    },
    methods: {
        get_seq_comp() {
            query_seq_comp(this.illness_name).then((res) => {
                console.log(res);
                this.rows=res.data;
            });
        },
        reset() {
            this.illness_name = "";
        },
    },
};
</script>

<style scoped>
.search {
    width: 30%;
    margin: 30px auto;
}
</style>
