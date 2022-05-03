<template>
    <div class="app-container">
        <el-form
            :model="queryParams"
            ref="queryForm"
            size="small"
            :inline="true"
            v-show="showSearch"
            label-width="68px"
        >
            <el-form-item label="药品名称" prop="drugName">
                <el-input
                    v-model="queryParams.drugName"
                    placeholder="请输入药品名称"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="成分" prop="ingredient">
                <el-input
                    v-model="queryParams.ingredient"
                    placeholder="请输入成分"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="药品特征" prop="appearance">
                <el-input
                    v-model="queryParams.appearance"
                    placeholder="请输入药品特征"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="规格" prop="specification">
                <el-input
                    v-model="queryParams.specification"
                    placeholder="请输入规格"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="用法" prop="instructions">
                <el-input
                    v-model="queryParams.instructions"
                    placeholder="请输入用法"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="禁忌" prop="tabu">
                <el-input
                    v-model="queryParams.tabu"
                    placeholder="请输入禁忌"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="不良反应" prop="adverseReaction">
                <el-input
                    v-model="queryParams.adverseReaction"
                    placeholder="请输入不良反应"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="批准文号" prop="approvalNumber">
                <el-input
                    v-model="queryParams.approvalNumber"
                    placeholder="请输入批准文号"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="贮藏方法" prop="storageMethod">
                <el-input
                    v-model="queryParams.storageMethod"
                    placeholder="请输入贮藏方法"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="包装" prop="packaging">
                <el-input
                    v-model="queryParams.packaging"
                    placeholder="请输入包装"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="有效期" prop="indata">
                <el-input
                    v-model="queryParams.indata"
                    placeholder="请输入有效期"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item label="删除标志" prop="isDelete">
                <el-input
                    v-model="queryParams.isDelete"
                    placeholder="请输入删除标志"
                    clearable
                    @keyup.enter.native="handleQuery"
                />
            </el-form-item>
            <el-form-item>
                <el-button
                    type="primary"
                    icon="el-icon-search"
                    size="mini"
                    @click="handleQuery"
                    >搜索</el-button
                >
                <el-button
                    icon="el-icon-refresh"
                    size="mini"
                    @click="resetQuery"
                    >重置</el-button
                >
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button
                    type="primary"
                    plain
                    icon="el-icon-plus"
                    size="mini"
                    @click="handleAdd"
                    v-hasPermi="['illness:drug:add']"
                    >新增</el-button
                >
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="success"
                    plain
                    icon="el-icon-edit"
                    size="mini"
                    :disabled="single"
                    @click="handleUpdate"
                    v-hasPermi="['illness:drug:edit']"
                    >修改</el-button
                >
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="danger"
                    plain
                    icon="el-icon-delete"
                    size="mini"
                    :disabled="multiple"
                    @click="handleDelete"
                    v-hasPermi="['illness:drug:remove']"
                    >删除</el-button
                >
            </el-col>
            <el-col :span="1.5">
                <el-button
                    type="warning"
                    plain
                    icon="el-icon-download"
                    size="mini"
                    @click="handleExport"
                    v-hasPermi="['illness:drug:export']"
                    >导出</el-button
                >
            </el-col>
            <right-toolbar
                :showSearch.sync="showSearch"
                @queryTable="getList"
            ></right-toolbar>
        </el-row>

        <el-table
            v-loading="loading"
            :data="drugList"
            @selection-change="handleSelectionChange"
        >
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="序号" align="center" prop="drugId" />
            <el-table-column label="药品名称" align="center" prop="drugName" />
            <el-table-column label="成分" align="center" prop="ingredient" />
            <el-table-column
                label="药品特征"
                align="center"
                prop="appearance"
            />
            <el-table-column label="规格" align="center" prop="specification" />
            <el-table-column label="用法" align="center" prop="instructions" />
            <el-table-column label="禁忌" align="center" prop="tabu" />
            <el-table-column
                label="不良反应"
                align="center"
                prop="adverseReaction"
            />
            <el-table-column
                label="批准文号"
                align="center"
                prop="approvalNumber"
            />
            <el-table-column
                label="贮藏方法"
                align="center"
                prop="storageMethod"
            />
            <el-table-column label="包装" align="center" prop="packaging" />
            <el-table-column label="有效期" align="center" prop="indata" />
            <el-table-column label="删除标志" align="center" prop="isDelete" />
            <el-table-column label="备注" align="center" prop="remark" />
            <el-table-column
                label="操作"
                align="center"
                class-name="small-padding fixed-width"
            >
                <template slot-scope="scope">
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-edit"
                        @click="handleUpdate(scope.row)"
                        v-hasPermi="['illness:drug:edit']"
                        >修改</el-button
                    >
                    <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-delete"
                        @click="handleDelete(scope.row)"
                        v-hasPermi="['illness:drug:remove']"
                        >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>

        <pagination
            v-show="total > 0"
            :total="total"
            :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize"
            @pagination="getList"
        />

        <!-- 添加或修改药品管理对话框 -->
        <el-dialog
            :title="title"
            :visible.sync="open"
            width="500px"
            append-to-body
        >
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="药品名称" prop="drugName">
                    <el-input
                        v-model="form.drugName"
                        placeholder="请输入药品名称"
                    />
                </el-form-item>
                <el-form-item label="成分" prop="ingredient">
                    <el-input
                        v-model="form.ingredient"
                        placeholder="请输入成分"
                    />
                </el-form-item>
                <el-form-item label="药品特征" prop="appearance">
                    <el-input
                        v-model="form.appearance"
                        placeholder="请输入药品特征"
                    />
                </el-form-item>
                <el-form-item label="规格" prop="specification">
                    <el-input
                        v-model="form.specification"
                        placeholder="请输入规格"
                    />
                </el-form-item>
                <el-form-item label="用法" prop="instructions">
                    <el-input
                        v-model="form.instructions"
                        placeholder="请输入用法"
                    />
                </el-form-item>
                <el-form-item label="禁忌" prop="tabu">
                    <el-input v-model="form.tabu" placeholder="请输入禁忌" />
                </el-form-item>
                <el-form-item label="不良反应" prop="adverseReaction">
                    <el-input
                        v-model="form.adverseReaction"
                        placeholder="请输入不良反应"
                    />
                </el-form-item>
                <el-form-item label="批准文号" prop="approvalNumber">
                    <el-input
                        v-model="form.approvalNumber"
                        placeholder="请输入批准文号"
                    />
                </el-form-item>
                <el-form-item label="贮藏方法" prop="storageMethod">
                    <el-input
                        v-model="form.storageMethod"
                        placeholder="请输入贮藏方法"
                    />
                </el-form-item>
                <el-form-item label="包装" prop="packaging">
                    <el-input
                        v-model="form.packaging"
                        placeholder="请输入包装"
                    />
                </el-form-item>
                <el-form-item label="有效期" prop="indata">
                    <el-input
                        v-model="form.indata"
                        placeholder="请输入有效期"
                    />
                </el-form-item>
                <el-form-item label="删除标志" prop="isDelete">
                    <el-input
                        v-model="form.isDelete"
                        placeholder="请输入删除标志"
                    />
                </el-form-item>
                <el-form-item label="备注" prop="remark">
                    <el-input v-model="form.remark" placeholder="请输入备注" />
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="cancel">取 消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import {
    listDrug,
    getDrug,
    delDrug,
    addDrug,
    updateDrug,
} from "@/api/illness/drug";

export default {
    name: "Drug",
    data() {
        return {
            // 遮罩层
            loading: true,
            // 选中数组
            ids: [],
            // 非单个禁用
            single: true,
            // 非多个禁用
            multiple: true,
            // 显示搜索条件
            showSearch: true,
            // 总条数
            total: 0,
            // 药品管理表格数据
            drugList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                drugName: null,
                ingredient: null,
                appearance: null,
                specification: null,
                instructions: null,
                tabu: null,
                adverseReaction: null,
                approvalNumber: null,
                storageMethod: null,
                packaging: null,
                indata: null,
                isDelete: null,
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {
                drugName: [
                    {
                        required: true,
                        message: "药品名称不能为空",
                        trigger: "blur",
                    },
                ],
                ingredient: [
                    {
                        required: true,
                        message: "成分不能为空",
                        trigger: "blur",
                    },
                ],
                appearance: [
                    {
                        required: true,
                        message: "药品特征不能为空",
                        trigger: "blur",
                    },
                ],
                specification: [
                    {
                        required: true,
                        message: "规格不能为空",
                        trigger: "blur",
                    },
                ],
                instructions: [
                    {
                        required: true,
                        message: "用法不能为空",
                        trigger: "blur",
                    },
                ],
                tabu: [
                    {
                        required: true,
                        message: "禁忌不能为空",
                        trigger: "blur",
                    },
                ],
                adverseReaction: [
                    {
                        required: true,
                        message: "不良反应不能为空",
                        trigger: "blur",
                    },
                ],
                approvalNumber: [
                    {
                        required: true,
                        message: "批准文号不能为空",
                        trigger: "blur",
                    },
                ],
                storageMethod: [
                    {
                        required: true,
                        message: "贮藏方法不能为空",
                        trigger: "blur",
                    },
                ],
                packaging: [
                    {
                        required: true,
                        message: "包装不能为空",
                        trigger: "blur",
                    },
                ],
                indata: [
                    {
                        required: true,
                        message: "有效期不能为空",
                        trigger: "blur",
                    },
                ],
                createBy: [
                    {
                        required: true,
                        message: "创建者不能为空",
                        trigger: "blur",
                    },
                ],
                updateBy: [
                    {
                        required: true,
                        message: "更新者不能为空",
                        trigger: "blur",
                    },
                ],
                remark: [
                    {
                        required: true,
                        message: "备注不能为空",
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询药品管理列表 */
        getList() {
            this.loading = true;
            listDrug(this.queryParams).then((response) => {
                this.drugList = response.rows;
                this.total = response.total;
                this.loading = false;
            });
        },
        // 取消按钮
        cancel() {
            this.open = false;
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                drugId: null,
                drugName: null,
                ingredient: null,
                appearance: null,
                specification: null,
                instructions: null,
                tabu: null,
                adverseReaction: null,
                approvalNumber: null,
                storageMethod: null,
                packaging: null,
                indata: null,
                isDelete: null,
                createBy: null,
                createTime: null,
                updateBy: null,
                updateTime: null,
                remark: null,
            };
            this.resetForm("form");
        },
        /** 搜索按钮操作 */
        handleQuery() {
            this.queryParams.pageNum = 1;
            this.getList();
        },
        /** 重置按钮操作 */
        resetQuery() {
            this.resetForm("queryForm");
            this.handleQuery();
        },
        // 多选框选中数据
        handleSelectionChange(selection) {
            this.ids = selection.map((item) => item.drugId);
            this.single = selection.length !== 1;
            this.multiple = !selection.length;
        },
        /** 新增按钮操作 */
        handleAdd() {
            this.reset();
            this.open = true;
            this.title = "添加药品管理";
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.reset();
            const drugId = row.drugId || this.ids;
            getDrug(drugId).then((response) => {
                this.form = response.data;
                this.open = true;
                this.title = "修改药品管理";
            });
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate((valid) => {
                if (valid) {
                    if (this.form.drugId != null) {
                        updateDrug(this.form).then((response) => {
                            this.$modal.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    } else {
                        addDrug(this.form).then((response) => {
                            this.$modal.msgSuccess("新增成功");
                            this.open = false;
                            this.getList();
                        });
                    }
                }
            });
        },
        /** 删除按钮操作 */
        handleDelete(row) {
            const drugIds = row.drugId || this.ids;
            this.$modal
                .confirm(
                    '是否确认删除药品管理编号为"' + drugIds + '"的数据项？'
                )
                .then(function () {
                    return delDrug(drugIds);
                })
                .then(() => {
                    this.getList();
                    this.$modal.msgSuccess("删除成功");
                })
                .catch(() => {});
        },
        /** 导出按钮操作 */
        handleExport() {
            this.download(
                "illness/drug/export",
                {
                    ...this.queryParams,
                },
                `drug_${new Date().getTime()}.xlsx`
            );
        },
    },
};
</script>
