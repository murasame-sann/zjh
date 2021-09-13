<template>
    <div>
        <el-container>
            <el-header>
                <img class="mlogo" src="https://www.markerhub.com/dist/images/logo/markerhub-logo.png" alt="">
            </el-header>
            <el-main>
                <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="formModel">
                    <el-form-item label="用户名" prop="username">
                        <el-input type="text" v-model="form.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="form.password"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit('form')">立即创建</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                form: {
                    username: 'hua',
                    password: '111111',
                },
                rules: {
                    username: [{required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 15, message: '长度为3到15个字符', trigger: 'blur'}],
                    password: [{required: true, message: '请输入密码', trigger: 'change'}]
                }
            }
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this
                        this.$axios.post('/login', this.form).then(
                            res => {
                                const jwt = res.headers['authorization'];
                                const userInfo = res.data.data

                                // 共享数据
                                _this.$store.commit("SET_TOKEN",jwt)
                                _this.$store.commit("SET_USERINFO",userInfo)

                                console.log(_this.$store.getters.getUser)

                                _this.$router.push("/blogs")
                            }
                        )
                    } else {
                        alert('submit wrong!');
                        return false
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .mlogo {
        height: 60%;
        margin-top: 10px;

    }

    .formModel {
        max-width: 500px;
        margin: 0 auto;
    }
</style>