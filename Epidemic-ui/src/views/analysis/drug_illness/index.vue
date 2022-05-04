<template>
  <div>
    <div class="search">
      <el-input v-model="illness_name" placeholder="请输入疾病名" />
      <el-button @click="reset">重置</el-button>
      <el-button @click="get_drug">确认</el-button>
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

import { query_drug } from "@/api/analysis/analysis.js";
import { VueGoodTable } from 'vue-good-table';
import 'vue-good-table/dist/vue-good-table.css'

export default {
    data() {
        return {
          columns: [
            {
              label: 'drug_id',
              field: 'drug_id',
              type:'int',
            },
            {
              label: 'company_name',
              field: 'company_name',
              type:'string'
            },
            {
              label: 'drug_name',
              field: 'drug_name',
              type: 'string'
            },
            {
              label: 'factory_name',
              field: 'factory_name',
              type: 'string'
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
        get_drug() {
            query_drug(this.illness_name).then((res) => {
                console.log(res);
                console.log(res.data);
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
