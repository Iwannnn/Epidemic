<template>
    <div>
        <div class="search">
            <el-input v-model="illness_name" placeholder="请输入疾病名" />
            <el-button @click="reset">重置</el-button>
            <el-button @click="get_patient_info">确认</el-button>
        </div>
        <div id="age_info" class="chart"></div>
        <div id="fat_info" class="chart"></div>
        <div id="height_info" class="chart"></div>
        <div id="weight_info" class="chart"></div>
    </div>
</template>

<script>
import { query_patient_info } from "@/api/analysis/analysis.js";

export default {
    data() {
        return {
            // 指定图表的配置项和数据
            illness_name: "",
            age_info: [
                { name: "   age<10", value: 0 },
                { name: "10<age<20", value: 0 },
                { name: "20<age<30", value: 0 },
                { name: "30<age<40", value: 0 },
                { name: "40<age<50", value: 0 },
                { name: "50<age<60", value: 0 },
                { name: "60<age<70", value: 0 },
                { name: "70<age", value: 0 },
            ],
            fat_info: [
                { name: "   fat<10", value: 0 },
                { name: "10<fat<20", value: 0 },
                { name: "20<fat<30", value: 0 },
                { name: "30<fat<40", value: 0 },
                { name: "40<fat", value: 0 },
            ],
            height_info: [
                { name: "    height<130", value: 0 },
                { name: "130<height<140", value: 0 },
                { name: "140<height<150", value: 0 },
                { name: "150<height<160", value: 0 },
                { name: "160<height<170", value: 0 },
                { name: "170<height<180", value: 0 },
                { name: "180<height<190", value: 0 },
                { name: "190<height", value: 0 },
            ],
            weight_info: [
                { name: "   weight<40", value: 0 },
                { name: "40<weight<50", value: 0 },
                { name: "50<weight<60", value: 0 },
                { name: "60<weight<70", value: 0 },
                { name: "70<weight<80", value: 0 },
                { name: "80<weight<90", value: 0 },
                { name: "90<weight", value: 0 },
            ],
            ageOption: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: [
                        "   age<10",
                        "10<age<20",
                        "20<age<30",
                        "30<age<40",
                        "40<age<50",
                        "50<age<60",
                        "60<age<70",
                        "70<age",
                    ],
                },
                series: [
                    {
                        name: "病例年龄分布",
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
                                fontSize: "20",
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
            fatOption: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: [
                        "   fat<10",
                        "10<fat<20",
                        "20<fat<30",
                        "30<fat<40",
                        "40<fat",
                    ],
                },
                series: [
                    {
                        name: "病例体脂分布",
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
                                fontSize: "20",
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
            heightOption: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: [
                        "    height<130",
                        "130<height<140",
                        "140<height<150",
                        "150<height<160",
                        "160<height<170",
                        "170<height<180",
                        "180<height<190",
                        "190<height",
                    ],
                },
                series: [
                    {
                        name: "病例身高分布",
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
                                fontSize: "20",
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
            weightOption: {
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    orient: "vertical",
                    left: 10,
                    data: [
                        "   weight<40",
                        "40<weight<50",
                        "50<weight<60",
                        "60<weight<70",
                        "70<weight<80",
                        "80<weight<90",
                        "90<weight",
                    ],
                },
                series: [
                    {
                        name: "病例体重分布",
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
                                fontSize: "20",
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
        get_patient_info() {
            var that = this;
            this.reset_chart();
            query_patient_info(this.illness_name).then((res) => {
                console.log(res);
                var i;
                for (i = 0; i < res.data.length; i++) {
                    that.addAge(res.data[i].age);
                    that.addFat(res.data[i].fat);
                    that.addHeight(res.data[i].height);
                    that.addWeight(res.data[i].weight);
                }
                // console.log(that.age_info);
                // console.log(that.fat_info);
                // console.log(that.weight_info);
                // console.log(that.height_info);
                that.ageOption.series[0].data = that.age_info;
                that.fatOption.series[0].data = that.fat_info;
                that.heightOption.series[0].data = that.height_info;
                that.weightOption.series[0].data = that.weight_info;
                that.init_echart();
            });
        },
        reset() {
            this.illness_name = "";
        },
        reset_chart() {
            (this.age_info = [
                { name: "   age<10", value: 0 },
                { name: "10<age<20", value: 0 },
                { name: "20<age<30", value: 0 },
                { name: "30<age<40", value: 0 },
                { name: "40<age<50", value: 0 },
                { name: "50<age<60", value: 0 },
                { name: "60<age<70", value: 0 },
                { name: "70<age", value: 0 },
            ]),
                (this.fat_info = [
                    { name: "   fat<10", value: 0 },
                    { name: "10<fat<20", value: 0 },
                    { name: "20<fat<30", value: 0 },
                    { name: "30<fat<40", value: 0 },
                    { name: "40<fat", value: 0 },
                ]),
                (this.height_info = [
                    { name: "    height<130", value: 0 },
                    { name: "130<height<140", value: 0 },
                    { name: "140<height<150", value: 0 },
                    { name: "150<height<160", value: 0 },
                    { name: "160<height<170", value: 0 },
                    { name: "170<height<180", value: 0 },
                    { name: "180<height<190", value: 0 },
                    { name: "190<height", value: 0 },
                ]),
                (this.weight_info = [
                    { name: "   weight<40", value: 0 },
                    { name: "40<weight<50", value: 0 },
                    { name: "50<weight<60", value: 0 },
                    { name: "60<weight<70", value: 0 },
                    { name: "70<weight<80", value: 0 },
                    { name: "80<weight<90", value: 0 },
                    { name: "90<weight", value: 0 },
                ]);
        },
        init_echart() {
            var ageChart = this.$echarts.init(
                document.getElementById("age_info")
            );
            ageChart.setOption(this.ageOption);
            var fatChart = this.$echarts.init(
                document.getElementById("fat_info")
            );
            fatChart.setOption(this.fatOption);
            var heightChart = this.$echarts.init(
                document.getElementById("height_info")
            );
            heightChart.setOption(this.heightOption);
            var weightChart = this.$echarts.init(
                document.getElementById("weight_info")
            );
            weightChart.setOption(this.weightOption);
        },
        addAge(age) {
            console.log(age);
            if (age < 10) this.age_info[0].value++;
            else if (age < 20) this.age_info[1].value++;
            else if (age < 30) this.age_info[2].value++;
            else if (age < 40) this.age_info[3].value++;
            else if (age < 50) this.age_info[4].value++;
            else if (age < 60) this.age_info[5].value++;
            else if (age < 70) this.age_info[6].value++;
            else if (age > 70) this.age_info[7].value++;
        },
        addFat(fat) {
            if (fat < 10) this.fat_info[0].value++;
            else if (fat < 20) this.fat_info[1].value++;
            else if (fat < 30) this.fat_info[2].value++;
            else if (fat < 40) this.fat_info[3].value++;
            else if (fat > 40) this.fat_info[4].value++;
        },
        addHeight(height) {
            if (height < 130) this.height_info[0].value++;
            else if (height < 140) this.height_info[1].value++;
            else if (height < 150) this.height_info[2].value++;
            else if (height < 160) this.height_info[3].value++;
            else if (height < 170) this.height_info[4].value++;
            else if (height < 180) this.height_info[5].value++;
            else if (height < 190) this.height_info[6].value++;
            else if (height > 190) this.height_info[7].value++;
        },
        addWeight(weight) {
            if (weight < 40) this.weight_info[0].value++;
            else if (weight < 50) this.weight_info[1].value++;
            else if (weight < 60) this.weight_info[2].value++;
            else if (weight < 70) this.weight_info[3].value++;
            else if (weight < 80) this.weight_info[4].value++;
            else if (weight < 90) this.weight_info[5].value++;
            else if (weight > 90) this.weight_info[6].value++;
        },
    },
    mounted: function () {},
};
</script>

<style scoped>
.search {
    width: 30%;
    margin: 30px auto;
}
.chart {
    width: 800px;
    height: 600px;
    margin: auto;
}
</style>
