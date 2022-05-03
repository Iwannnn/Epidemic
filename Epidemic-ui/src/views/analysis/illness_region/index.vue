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
import regionList from "./region.json";

export default {
    data() {
        return {
            // 指定图表的配置项和数据
            illness_name: "",
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
                var i;
                for (i = 0; i < res.data.length; i++) {
                    that.option.legend.data.push(
                        regionList[res.data[i].regionId - 1].location
                    );
                    that.option.series[0].data.push({
                        value: res.data[i].count,
                        name: regionList[res.data[i].regionId - 1].location,
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
