<template>
    <div>
        <div class="layout-flex-row">
            <div class="head-back-button-container">
                <button class="rich-editor-submit-button" @click="submit">返回主页</button>
            </div>

            <div class="heard-title-input-container">
                <input class="heard-title-input" />
            </div>
            <div class="head-icon-button-container layout-flex-row">
                <button class="rich-editor-submit-button" @click="submit">保存草稿</button>

                <button class="rich-editor-submit-button" @click="submit">发布文章</button>
                <el-avatar shape="square" :size="40" :src="squareUrl" style="margin-left: auto;" />
            </div>
        </div>

        <!-- 小屏幕显示博客标题 -->
        <div class="" style="display: none;">
            <input class="" />
        </div>

        <div>
            <mavon-editor v-model="content" ref="md" @change="change" style="min-height: 600px" />
        </div>
        
    </div>
</template>

<script>
// 导入组件 及 组件样式
import { mavonEditor } from 'mavon-editor'
import "mavon-editor/dist/css/index.css"

export default {
    // 注册
    components: {
        mavonEditor,
    },
    data() {
        return {
            content: '', // 输入的markdown
            html: '',    // 及时转的html
            squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
        }
    },
    methods: {
        // 所有操作都会被解析重新渲染
        change(value, render) {
            // render 为 markdown 解析后的结果[html]
            this.html = render;
            console.log(this.html);
        },
        // 提交
        submit() {
            sessionStorage.setItem("html", this.html);
            console.log(this.content);
            console.log(this.html);
        }
    },
    mounted() {

    }
}
</script>

<style scoped>
button {
    outline: none;
}


.layout-flex-row {
    display: flex;
    flex-direction: row;
}

.layout-flex-column {
    display: flex;
    flex-direction: column;
}

.flex-end {
    align-self: flex-end;
}

.flex-center {
    align-self: center;
}

.heard-title-input-container {
    width: 80%;
}

.heard-title-input {
    width: 100%;
    height: 90%;
    outline: none;
    border: 1px solid red;
    transition: 200ms;
    font-size: 15px;
    border-radius: 5px;
}

.heard-title-input:focus {
    width: 100%;
    transition: 200ms;
}

.head-back-button-container {
    width: 200px;
}

.head-icon-button-container {
    width: 400px;
    margin-left: auto;
}

.rich-editor-submit-button {
    width: 110px;
    height: 40px;
    margin-left: auto;
    font-size: 20px;
    border: 1px solid red;
    border-radius: 5px;
    background-color: white;
    color: red;
}

.rich-editor-submit-button:hover {
    background-color: red;
    color: white;
    transition: 500ms;
}
</style>