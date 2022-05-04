<template>
    <div>
        <div class="search">
            <el-input v-model="illness_name" placeholder="请输入疾病名" />
            <el-button @click="reset">重置</el-button>
            <el-button @click="get_death_rate">确认</el-button>
        </div>
        <div id="death_rate" class="chart"></div>
    </div>
</template>

<script>
import { query_death_info } from "@/api/analysis/analysis.js";

export default {
    data() {
        return {
            // 指定图表的配置项和数据
            illness_name: "",
            death_data: {
                alive_num: 0,
                death_num: 0,
            },
            option: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: ["死亡人数", "未死亡人数"],
                },
                series: [
                    {
                        name: "死亡率",
                        type: "pie",
                        radius: ["50%", "70%"],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: "center",
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
                        data: [
                            { value: 0, name: "死亡人数" },
                            { value: 0, name: "未死亡人数" },
                        ],
                    },
                ],
            },
        };
    },
    methods: {
        get_death_rate() {
            // console.log("get_death rate");
            // console.log(this.illness_name);
            this.option.series[0].data[0].value = 0;
            this.option.series[0].data[1].value = 0;
            query_death_info(this.illness_name).then((res) => {
                console.log(res);
                this.option.series[0].data[0].value = res.data.death_number;
                this.option.series[0].data[1].value =
                    res.data.all_number - res.data.death_number;
                this.init_echart();
            });
        },
        init_echart() {
            var myChart = this.$echarts.init(
                document.getElementById("death_rate")
            );
            // this.option.series[0].data[0].value =
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(this.option);
        },
        reset() {
            this.illness_name = "";
        },
    },
    mounted: function () {
        // this.get_death_rate();
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
