<template>
    <div>
        <div class="search">
            <el-input v-model="illness_name" placeholder="请输入疾病名" />
            <el-button @click="reset">重置</el-button>
            <el-button @click="get_diff_time">确认</el-button>
        </div>
        <div id="cure_info" class="chart"></div>
    </div>
</template>

<script>
import { query_diff_time } from "@/api/analysis/analysis.js";

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
                        name: "治愈时间分布",
                        type: "pie",
                        radius: ["30%", "60%"],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: "left",
                        },
                        emphasis: {
                            label: {
                                show: true,
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
        get_diff_time() {
            var that = this;
            query_diff_time(this.illness_name).then((res) => {
                console.log(res);
                var i;
                for (i = 0; i < res.data.length; i++) {
                    that.option.legend.data.push(res.data[i].diff_time + "天");
                    that.option.series[0].data.push({
                        value: res.data[i].cure_count,
                        name: res.data[i].diff_time + "天",
                    });
                }
                that.init_echart();
            });
        },
        init_echart() {
            var myChart = this.$echarts.init(
                document.getElementById("cure_info")
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
