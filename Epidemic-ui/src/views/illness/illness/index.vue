<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病id" prop="illnessId">
        <el-input
          v-model="queryParams.illnessId"
          placeholder="请输入病id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="病名" prop="illnessName">
        <el-input
          v-model="queryParams.illnessName"
          placeholder="请输入病名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属类id" prop="catrgoryId">
        <el-input
          v-model="queryParams.catrgoryId"
          placeholder="请输入所属类id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="症状描述" prop="symptom">
        <el-input
          v-model="queryParams.symptom"
          placeholder="请输入症状描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="病原描述" prop="pathogeny">
        <el-input
          v-model="queryParams.pathogeny"
          placeholder="请输入病原描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="严重性描述" prop="ponderance">
        <el-input
          v-model="queryParams.ponderance"
          placeholder="请输入严重性描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否传染" prop="isFectious">
        <el-input
          v-model="queryParams.isFectious"
          placeholder="请输入是否传染"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除标志" prop="isDeleted">
        <el-input
          v-model="queryParams.isDeleted"
          placeholder="请输入删除标志"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建者" prop="craetedBy">
        <el-input
          v-model="queryParams.craetedBy"
          placeholder="请输入创建者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createdTime">
        <el-date-picker clearable
          v-model="queryParams.createdTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['illness:illness:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['illness:illness:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['illness:illness:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['illness:illness:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="illnessList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="病id" align="center" prop="illnessId" />
      <el-table-column label="病名" align="center" prop="illnessName" />
      <el-table-column label="所属类id" align="center" prop="catrgoryId" />
      <el-table-column label="症状描述" align="center" prop="symptom" />
      <el-table-column label="病原描述" align="center" prop="pathogeny" />
      <el-table-column label="严重性描述" align="center" prop="ponderance" />
      <el-table-column label="是否传染" align="center" prop="isFectious" />
      <el-table-column label="删除标志" align="center" prop="isDeleted" />
      <el-table-column label="创建者" align="center" prop="craetedBy" />
      <el-table-column label="创建时间" align="center" prop="createdTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['illness:illness:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['illness:illness:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改疾病管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病名" prop="illnessName">
          <el-input v-model="form.illnessName" placeholder="请输入病名" />
        </el-form-item>
        <el-form-item label="所属类id" prop="catrgoryId">
          <el-input v-model="form.catrgoryId" placeholder="请输入所属类id" />
        </el-form-item>
        <el-form-item label="症状描述" prop="symptom">
          <el-input v-model="form.symptom" placeholder="请输入症状描述" />
        </el-form-item>
        <el-form-item label="病原描述" prop="pathogeny">
          <el-input v-model="form.pathogeny" placeholder="请输入病原描述" />
        </el-form-item>
        <el-form-item label="严重性描述" prop="ponderance">
          <el-input v-model="form.ponderance" placeholder="请输入严重性描述" />
        </el-form-item>
        <el-form-item label="是否传染" prop="isFectious">
          <el-input v-model="form.isFectious" placeholder="请输入是否传染" />
        </el-form-item>
        <el-form-item label="删除标志" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="创建者" prop="craetedBy">
          <el-input v-model="form.craetedBy" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createdTime">
          <el-date-picker clearable
            v-model="form.createdTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
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
import { listIllness, getIllness, delIllness, addIllness, updateIllness } from "@/api/illness/illness";

export default {
  name: "Illness",
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
      // 疾病管理表格数据
      illnessList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        illnessId: null,
        illnessName: null,
        catrgoryId: null,
        symptom: null,
        pathogeny: null,
        ponderance: null,
        isFectious: null,
        isDeleted: null,
        craetedBy: null,
        createdTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        illnessName: [
          { required: true, message: "病名不能为空", trigger: "blur" }
        ],
        catrgoryId: [
          { required: true, message: "所属类id不能为空", trigger: "blur" }
        ],
        symptom: [
          { required: true, message: "症状描述不能为空", trigger: "blur" }
        ],
        pathogeny: [
          { required: true, message: "病原描述不能为空", trigger: "blur" }
        ],
        ponderance: [
          { required: true, message: "严重性描述不能为空", trigger: "blur" }
        ],
        isFectious: [
          { required: true, message: "是否传染不能为空", trigger: "blur" }
        ],
        isDeleted: [
          { required: true, message: "删除标志不能为空", trigger: "blur" }
        ],
        craetedBy: [
          { required: true, message: "创建者不能为空", trigger: "blur" }
        ],
        updateBy: [
          { required: true, message: "更新者不能为空", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询疾病管理列表 */
    getList() {
      this.loading = true;
      listIllness(this.queryParams).then(response => {
        this.illnessList = response.rows;
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
        illnessId: null,
        illnessName: null,
        catrgoryId: null,
        symptom: null,
        pathogeny: null,
        ponderance: null,
        isFectious: null,
        isDeleted: null,
        craetedBy: null,
        createdTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.illnessId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加疾病管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const illnessId = row.illnessId || this.ids
      getIllness(illnessId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改疾病管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.illnessId != null) {
            updateIllness(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIllness(this.form).then(response => {
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
      const illnessIds = row.illnessId || this.ids;
      this.$modal.confirm('是否确认删除疾病管理编号为"' + illnessIds + '"的数据项？').then(function() {
        return delIllness(illnessIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('illness/illness/export', {
        ...this.queryParams
      }, `illness_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
