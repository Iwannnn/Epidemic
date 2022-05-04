<template>
  <div>
    <div class="search">
      <el-input v-model="patient_name" placeholder="请输入疾病名" />
      <el-button @click="reset">重置</el-button>
      <el-button @click="get_history">确认</el-button>
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

import { query_pat_history } from "@/api/analysis/analysis.js";
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
      patient_name: "",
    };
  },
  components: {
    VueGoodTable,
  },
    methods: {
        get_history() {
            query_pat_history(this.patient_name).then((res) => {
                console.log(res);
                this.rows=res.data;
            });
        },
        reset() {
            this.patient_name = "";
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
