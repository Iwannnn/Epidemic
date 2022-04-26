<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="传播途径id" prop="transmissionId">
        <el-input
          v-model="queryParams.transmissionId"
          placeholder="请输入传播途径id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="传播途径名" prop="transmissionName">
        <el-input
          v-model="queryParams.transmissionName"
          placeholder="请输入传播途径名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="影响范围" prop="distance">
        <el-input
          v-model="queryParams.distance"
          placeholder="请输入影响范围"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="持续时间" prop="duration">
        <el-input
          v-model="queryParams.duration"
          placeholder="请输入持续时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="传播源" prop="transSource">
        <el-input
          v-model="queryParams.transSource"
          placeholder="请输入传播源"
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
          v-hasPermi="['illness:transmission:add']"
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
          v-hasPermi="['illness:transmission:edit']"
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
          v-hasPermi="['illness:transmission:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['illness:transmission:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="transmissionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="传播途径id" align="center" prop="transmissionId" />
      <el-table-column label="传播途径名" align="center" prop="transmissionName" />
      <el-table-column label="影响范围" align="center" prop="distance" />
      <el-table-column label="持续时间" align="center" prop="duration" />
      <el-table-column label="传播源" align="center" prop="transSource" />
      <el-table-column label="删除标志" align="center" prop="isDelete" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['illness:transmission:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['illness:transmission:remove']"
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

    <!-- 添加或修改传播管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="传播途径名" prop="transmissionName">
          <el-input v-model="form.transmissionName" placeholder="请输入传播途径名" />
        </el-form-item>
        <el-form-item label="影响范围" prop="distance">
          <el-input v-model="form.distance" placeholder="请输入影响范围" />
        </el-form-item>
        <el-form-item label="持续时间" prop="duration">
          <el-input v-model="form.duration" placeholder="请输入持续时间" />
        </el-form-item>
        <el-form-item label="传播源" prop="transSource">
          <el-input v-model="form.transSource" placeholder="请输入传播源" />
        </el-form-item>
        <el-form-item label="删除标志" prop="isDelete">
          <el-input v-model="form.isDelete" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listTransmission, getTransmission, delTransmission, addTransmission, updateTransmission } from "@/api/illness/transmission";

export default {
  name: "Transmission",
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
      // 传播管理表格数据
      transmissionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        transmissionId: null,
        transmissionName: null,
        distance: null,
        duration: null,
        transSource: null,
        isDelete: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        transmissionName: [
          { required: true, message: "传播途径名不能为空", trigger: "blur" }
        ],
        distance: [
          { required: true, message: "影响范围不能为空", trigger: "blur" }
        ],
        duration: [
          { required: true, message: "持续时间不能为空", trigger: "blur" }
        ],
        transSource: [
          { required: true, message: "传播源不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询传播管理列表 */
    getList() {
      this.loading = true;
      listTransmission(this.queryParams).then(response => {
        this.transmissionList = response.rows;
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
        transmissionId: null,
        transmissionName: null,
        distance: null,
        duration: null,
        transSource: null,
        isDelete: null,
        createTime: null,
        createBy: null,
        updateTime: null,
        updateBy: null,
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
      this.ids = selection.map(item => item.transmissionId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加传播管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const transmissionId = row.transmissionId || this.ids
      getTransmission(transmissionId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改传播管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.transmissionId != null) {
            updateTransmission(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTransmission(this.form).then(response => {
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
      const transmissionIds = row.transmissionId || this.ids;
      this.$modal.confirm('是否确认删除传播管理编号为"' + transmissionIds + '"的数据项？').then(function() {
        return delTransmission(transmissionIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('illness/transmission/export', {
        ...this.queryParams
      }, `transmission_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
