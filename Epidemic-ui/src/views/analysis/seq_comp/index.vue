<template>
    <div class="search">
        <el-input v-model="illness_name" placeholder="请输入疾病名" />
        <el-button @click="reset">重置</el-button>
        <el-button @click="get_seq_comp">确认</el-button>
    </div>
</template>

<script>
import { query_seq_comp } from "@/api/analysis/analysis.js";
export default {
    data() {
        return {
            illness_name: "",
        };
    },
    methods: {
        get_seq_comp() {
            query_seq_comp(this.illness_name).then((res) => {
                console.log(res);
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
