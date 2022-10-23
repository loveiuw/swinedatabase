const { createEditor, createToolbar } = window.wangEditor

// 编辑器配置
const editorConfig = {}
editorConfig.placeholder = '请输入内容'
editorConfig.onChange = (editor) => {
    // 当编辑器选区、内容变化时，即触发
    console.log('content', editor.children)
    console.log('html', editor.getHtml())
}
// 工具栏配置
const toolbarConfig = {}
// 创建编辑器
const editor = createEditor({
    selector: '#editor-container',
    config: editorConfig,
    mode: 'simple' // 或 'simple' 参考下文
})
// 创建工具栏
const toolbar = createToolbar({
    editor,
    selector: '#toolbar-container',
    config: toolbarConfig,
    mode: 'simple' // 或 'simple' 参考下文
})
//绑定按钮
document.getElementById('textsubmit').addEventListener('click', function () {
    var text = editor.getHtml();
    // alert(text)
    text=encodeURIComponent(text);
    var param = { Text: text }
    var params = JSON.stringify(param);
    $.ajax({
        url: "/contact/processdata",
        type: "post",
        data: text,
        // data: {"username":"张三"},
        dataType: "text",
        success: function (response) {
            console.log("表单提交成功")
            // alert("获取到新数据")
            console.log(response)
            window.location.reload()
            // $('#userTable').html(response)
        },
        error: function (XMLHttpRequest){
            // alert(XMLHttpRequest.responseText)
            $('#userTable').html(response)
        }
    })
}, false)