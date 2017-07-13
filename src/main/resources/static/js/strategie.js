var voidValue = {//策略者
    C : {},//默认配置规则
    M : {//未通过验证时输出的信息
        isEmpty : 'EMPTY',
        isPhone : 'NOTPHONE',
        isBoolean : 'NOTBOOLEAN',
        isLength : 'BIGGER THAN MAX',
        isUndefined : 'UNDEFINED',
        isNumber : 'NOTNUMBER'
    },
    R : {//自定义规则，所有的规则在里面逐步添加
        isEmpty : function(v) {
            return v != '';
        },
        isUndefined :  function(v) {
            return typeof v === 'undefined';
        },
        isPhone : function(v) {
            return /^1[3|4|5|8]\d{9}$/.test(v);
        },
        isBoolean : function(v) {
            return Object.prototype.toString.call(v) === '[object Boolean]';
        },
        isNumber : function(v) {
            return Object.prototype.toString.call(v) === '[object Number]';
        },
        isName :  function(v) {
            return /^[\u4E00-\u9FFF]{1,6}$/.test(v);
        },<br>　　　　　　　　　　　　　　　　　　　　isAdress : function(v) {<br>　　　　　　　　　　　　　　　　　　　　　　　　return this.isEmpty(v) && v.length<200;<br>　　　　　　　　　　　　　　　　　　　　}<br>
},
vaild : function(d) {//入口函数，传入数据源
    for(var i in d) {//循环传入的对象
        if(!this.C[i]) continue;
        if(this.C[i].fn) {//判断是否有用户自定义输出的字符串，这里其实是经常用到的，比如某个字段没有通过验证需要怎么样提示，以及提示的文字，在验证表单是尤其重要！
            var fn = this.R[this.C[i]['fn']] || this.C[i]['fn'], message = this.C[i]['tip'];
        }else {
            var fn = this.R[this.C[i]] || this.C[i], message = this.M[this.C[i]];
        }
        var t = Object.prototype.toString.call(fn);//这里我们判断是需要执行验证函数还是比对数值大小
        if(t === '[object Function]') {
            if(!fn(d[i])) {
                console.warn(message);
                return false;
            }
        }else if(t === '[object Number]') {
            if(!/\d+/.test(d[i]) || parseInt(d[i]) >= fn) {
                console.warn(message);
                return false;
            }
        }
    }
    return d;//如果都匹配到了，可以输出完整的数据源对象。
}
}

var registerForm = document.getElementById('login')
registerForm.onsubmit = function  () {
    var errorMsg = validatorFunc()   // this is a instance!!!
    if(errorMsg)
        alert(errorMsg)
    return false
}