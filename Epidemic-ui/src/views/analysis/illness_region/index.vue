<template>
    <div>
        <div class="search">
            <el-input v-model="illness_name" placeholder="请输入疾病名" />
            <el-button @click="reset">重置</el-button>
            <el-button @click="get_region_rate">确认</el-button>
        </div>
        <div id="region_info" class="chart"></div>
    </div>
</template>

<script>
import { query_region_info } from "@/api/analysis/analysis.js";
// import regionList from "./region.json";

export default {
    data() {
        return {
            // 指定图表的配置项和数据
            illness_name: "",
            regionList: [
                {
                    id: 1,
                    location: "A_p.A_c,A_d_1,A_S_1",
                },
                {
                    id: 2,
                    location: "A_p,A_c_1,A_d_2,A_s_2",
                },
                {
                    id: 3,
                    location: "B_p,B_c_1,B_d_1,B_s_1",
                },
                {
                    id: 4,
                    location: "B_p,B_c_1,B_d_1,B_s_2",
                },
                {
                    id: 5,
                    location: "B_p,B_c_1,B_d_2,B_s_3",
                },
                {
                    id: 6,
                    location: "B_p,B_c_1,B_d_2,B_s_4",
                },
                {
                    id: 7,
                    location: "B_p,B_c_2,B_d_3,B_s_5",
                },
                {
                    id: 8,
                    location: "B_p,B_c_2,B_d_3,B_s_6",
                },
                {
                    id: 9,
                    location: "B_p,B_c_2,B_d_3,B_s_7",
                },
                {
                    id: 10,
                    location: "C_p,C_c_1,C_d_1,C_s_1",
                },
                {
                    id: 11,
                    location: "C_p,C_c_2,C_d_2,C_s_2",
                },
            ],
            option: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: [],
                },
                series: [
                    {
                        name: "城市感染分布",
                        type: "pie",
                        radius: ["30%", "70%"],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: "left",
                        },
                        emphasis: {
                            label: {
                                show: false,
                                fontSize: "30",
                                fontWeight: "bold",
                            },
                        },
                        labelLine: {
                            show: false,
                        },
                        data: [],
                    },
                ],
            },
        };
    },
    methods: {
        get_region_rate() {
            var that = this;
            query_region_info(this.illness_name).then((res) => {
                console.log(res);
                var i;
                for (i = 0; i < res.data.length; i++) {
                    that.option.legend.data.push(
                        this.regionList[res.data[i].region_id - 1].location
                    );
                    that.option.series[0].data.push({
                        value: res.data[i].count,
                        name: this.regionList[res.data[i].region_id - 1]
                            .location,
                    });
                }
                that.init_echart();
            });
        },
        init_echart() {
            var myChart = this.$echarts.init(
                document.getElementById("region_info")
            );
            myChart.setOption(this.option);
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
.chart {
    width: 600px;
    height: 400px;
    margin: auto;
}
</style>
