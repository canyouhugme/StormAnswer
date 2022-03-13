<template>
  <div class="hello">
    <div class="head">
      <h1>帅张问答录</h1>
<!--      <span class="right">头像</span>-->
    </div>
    <div class="content">
      <div class="input-bar">
        <div class="search">
          <input placeholder="输入你想要的内容">  <button>搜索</button>
        </div>
        <div class="enter">
          <input placeholder="输入文章地址">  <button>解析</button>
          <button>录入</button>
        </div>
      </div>

      <div class="question-answer">
        <div class="qa">
          <div class="question">
            <span>球友提问:</span>
            <span>请问如何进行职业规划？</span>
          </div>
          <div class="answer">
            <span>帅张回答:</span>
            <span>你觉得要怎么弄呢  {{text}}</span>
          </div>
        </div>

      </div>

    </div>
  </div>
</template>

<script>
import req from '@/http/api'

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      text: "测试文本"
    }
  },
  mounted() {
    // 调请求
    console.log('testn mounted')

    let params = {
      pageSize : 10,
      pageNo: 1
    }
    req.getQa(params.pageSize, params.pageNo).then(res => {
      console.log('res', res)
    })
  },


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

.hello {

  .content {
    margin: 0 20% 0 20%;

    .input-bar {
      margin: 10px;

      .search {
        margin: 10px 0 10px 0;
      }
    }

    .question-answer {
      margin: 10px;
    }
  }
}

h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
