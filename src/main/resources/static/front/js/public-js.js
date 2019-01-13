function checkInput(txt,value) {    //输入信息校验
    var txt = $(txt);
    if(txt.val() == ""){
        txt.parent().parent().removeClass()
        .addClass("form-group has-error has-feedback");
        txt.next().removeClass()
        .addClass("glyphicon glyphicon-remove form-control-feedback");
        console.log(value);
        alert(value+'不能为空');
        return false;
    }else{
        txt.parent().parent().removeClass()
        .addClass("form-group has-success has-feedback");
        txt.next().removeClass()
        .addClass("glyphicon glyphicon-ok form-control-feedback");
        return true;
    }
}