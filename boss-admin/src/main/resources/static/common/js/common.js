/**
 * @description:  js工具类 依赖jquery
 * @date: 2019/7/5 13:13
 * @author: fdh
 */
lays = {
    code : {
      success : 1
    },
    icon : {
        warn : 0,
        success : 1,
        fail : 2,
        doubt : 3,
        lock : 4,
        failWithFace : 5,
        successWithFace : 6
    }
}

common = {
    res : {
        success : function (result) {
            if(result.code == lays.code.success || result.code == (lays.code.success + '') ){
                return true;
            }else{
                return false;
            }
        },
        fail : function (result) {
            return !$.res.success(result);
        }
    },
    alert : {
        success : function (msg, callback) {
            layer.msg( (msg == null ? "成功！" : msg), {
                icon : lays.icon.successWithFace,
                time: 2000
            },callback);
        },
        fail : function (msg, callback) {
            layer.msg((msg == null ? "网络繁忙，请稍后再试！" : msg), {
                icon : lays.icon.failWithFace,
                time: 2000
            },callback);
        },
        warn : function (msg,callback) {
            layer.msg(msg,{
                icon : lays.icon.warn,
                time: 2000
            },callback);
        }
    }
}