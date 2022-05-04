<template>
    <div class="search">
        <el-input v-model="patient_name" placeholder="请输入患者名称" />
        <el-button @click="reset">重置</el-button>
        <el-button @click="get_history">确认</el-button>
    </div>
</template>

<script>
import { query_pat_history } from "@/api/analysis/analysis.js";
export default {
    data() {
        return {
            patient_name: "",
        };
    },
    methods: {
        get_history() {
            query_pat_history(this.patient_name).then((res) => {
                console.log(res);
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
