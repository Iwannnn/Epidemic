<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="专家id" prop="expertId">
        <el-input
          v-model="queryParams.expertId"
          placeholder="请输入专家id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专家姓名" prop="expertName">
        <el-input
          v-model="queryParams.expertName"
          placeholder="请输入专家姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专家年龄" prop="expertAge">
        <el-input
          v-model="queryParams.expertAge"
          placeholder="请输入专家年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专家介绍" prop="introduction">
        <el-input
          v-model="queryParams.introduction"
          placeholder="请输入专家介绍"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idNumber">
        <el-input
          v-model="queryParams.idNumber"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="政治面貌" prop="outlook">
        <el-input
          v-model="queryParams.outlook"
          placeholder="请输入政治面貌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-input
          v-model="queryParams.education"
          placeholder="请输入学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="telephone">
        <el-input
          v-model="queryParams.telephone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱号" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="隶属医院id" prop="hospitalId">
        <el-input
          v-model="queryParams.hospitalId"
          placeholder="请输入隶属医院id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="liveRegionId">
        <el-input
          v-model="queryParams.liveRegionId"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="详细地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入详细地址"
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
          v-hasPermi="['cases:expert:add']"
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
          v-hasPermi="['cases:expert:edit']"
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
          v-hasPermi="['cases:expert:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['cases:expert:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="expertList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="专家id" align="center" prop="expertId" />
      <el-table-column label="专家姓名" align="center" prop="expertName" />
      <el-table-column label="专家性别" align="center" prop="expertSex" />
      <el-table-column label="专家年龄" align="center" prop="expertAge" />
      <el-table-column label="专家介绍" align="center" prop="introduction" />
      <el-table-column label="身份证号" align="center" prop="idNumber" />
      <el-table-column label="政治面貌" align="center" prop="outlook" />
      <el-table-column label="学历" align="center" prop="education" />
      <el-table-column label="手机号" align="center" prop="telephone" />
      <el-table-column label="邮箱号" align="center" prop="email" />
      <el-table-column label="隶属医院id" align="center" prop="hospitalId" />
      <el-table-column label="地址" align="center" prop="liveRegionId" />
      <el-table-column label="详细地址" align="center" prop="address" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="删除标志" align="center" prop="isDelete" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cases:expert:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cases:expert:remove']"
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

    <!-- 添加或修改专家管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专家姓名" prop="expertName">
          <el-input v-model="form.expertName" placeholder="请输入专家姓名" />
        </el-form-item>
        <el-form-item label="专家年龄" prop="expertAge">
          <el-input v-model="form.expertAge" placeholder="请输入专家年龄" />
        </el-form-item>
        <el-form-item label="专家介绍" prop="introduction">
          <el-input v-model="form.introduction" placeholder="请输入专家介绍" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idNumber">
          <el-input v-model="form.idNumber" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="outlook">
          <el-input v-model="form.outlook" placeholder="请输入政治面貌" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-input v-model="form.education" placeholder="请输入学历" />
        </el-form-item>
        <el-form-item label="手机号" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮箱号" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱号" />
        </el-form-item>
        <el-form-item label="隶属医院id" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入隶属医院id" />
        </el-form-item>
        <el-form-item label="地址" prop="liveRegionId">
          <el-input v-model="form.liveRegionId" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入详细地址" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="删除标志" prop="isDelete">
          <el-input v-model="form.isDelete" placeholder="请输入删除标志" />
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
import { listExpert, getExpert, delExpert, addExpert, updateExpert } from "@/api/cases/expert";

export default {
  name: "Expert",
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
      // 专家管理表格数据
      expertList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        expertId: null,
        expertName: null,
        expertSex: null,
        expertAge: null,
        introduction: null,
        idNumber: null,
        outlook: null,
        education: null,
        telephone: null,
        email: null,
        hospitalId: null,
        liveRegionId: null,
        address: null,
        isDelete: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        expertName: [
          { required: true, message: "专家姓名不能为空", trigger: "blur" }
        ],
        expertSex: [
          { required: true, message: "专家性别不能为空", trigger: "change" }
        ],
        expertAge: [
          { required: true, message: "专家年龄不能为空", trigger: "blur" }
        ],
        introduction: [
          { required: true, message: "专家介绍不能为空", trigger: "blur" }
        ],
        idNumber: [
          { required: true, message: "身份证号不能为空", trigger: "blur" }
        ],
        outlook: [
          { required: true, message: "政治面貌不能为空", trigger: "blur" }
        ],
        education: [
          { required: true, message: "学历不能为空", trigger: "blur" }
        ],
        telephone: [
          { required: true, message: "手机号不能为空", trigger: "blur" }
        ],
        email: [
          { required: true, message: "邮箱号不能为空", trigger: "blur" }
        ],
        hospitalId: [
          { required: true, message: "隶属医院id不能为空", trigger: "blur" }
        ],
        liveRegionId: [
          { required: true, message: "地址不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "详细地址不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询专家管理列表 */
    getList() {
      this.loading = true;
      listExpert(this.queryParams).then(response => {
        this.expertList = response.rows;
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
        expertId: null,
        expertName: null,
        expertSex: null,
        expertAge: null,
        introduction: null,
        idNumber: null,
        outlook: null,
        education: null,
        telephone: null,
        email: null,
        hospitalId: null,
        liveRegionId: null,
        address: null,
        createTime: null,
        createBy: null,
        updateTime: null,
        updateBy: null,
        remark: null,
        isDelete: null
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
      this.ids = selection.map(item => item.expertId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加专家管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const expertId = row.expertId || this.ids
      getExpert(expertId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改专家管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.expertId != null) {
            updateExpert(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExpert(this.form).then(response => {
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
      const expertIds = row.expertId || this.ids;
      this.$modal.confirm('是否确认删除专家管理编号为"' + expertIds + '"的数据项？').then(function() {
        return delExpert(expertIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cases/expert/export', {
        ...this.queryParams
      }, `expert_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
