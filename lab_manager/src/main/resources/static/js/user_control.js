$(
    function(){
        $.ajax({
            type:'post',
            dataType:'json',
            url:'../../../java/com/bupt317/study/lab_manager/pojo/mybatis/UserInformation.java',
            error:function(data){
                console.log(JSON.stringify(data)),
                alert('请求失败')
             },
            success:function(data){
                console.log(data);
                for(item in JSON.stringify(data)){
                    user+=`            <tr>
											<td>
												姓名：<input type="text" name="userName " value="${data[item].stu_name}" disabled="true"/ >
											</td>
											<td>
												学号：<input type="text" name="userN " value="${data[item].sutdentid}" disabled="true"/ >
											</td>
											<td>
												<button type="button" >删除</button>
											</td>
											<td>
												<button type="button" class="bordershow1"  >个人信息设置</button>
											</td>
											<td>
												<button type="button" class="bordershow2" >权限设置</button>
											</td>
										</tr>
										<br/>`
                    var id  = data[item].id;
                    $('body').on('click','.bordershow1',function(){
                        $('.userInfo').show();
                    });
                    $('body').on('click','.bordershow2',function(){
                        $('.authoritySet').show();
                    });
                }
                $('.form4 table').after(user);
            }
        })
    }
);
$(function() {
    $('#save').click(function() {
        var d = [];
        var t = $('#form5').serializeArray();
        $.each(t, function() {
            d.push(this.value);
        });
        var i = 0;
        for( i = 0; i<d.length ; i++){
            if(d[i] == ''){
                break;
            }
        }
        if (i == 0){
            alert("请填写姓名");
            return false;
        }
        else if(i == 1) {
            alert("请选择性别");
            return false;
        }
        else if(i == 2) {
            alert("请填写学号");
            return false;
        }
        else if(i == 3) {
            alert("请选择导师姓名");
            return false;
        }
        else if(i== 4) {
            alert("请填写专业名称");
            return false;
        }
        else if(i == 5) {
            alert("请填写班级");
            return false;
        }
        else if (i == 6|| i==7 ){
            $.ajax({
                type:'post',
                dataType:'json',
                url:'../../../java/com/bupt317/study/lab_manager/pojo/mybatis/UserInformation.java',
                data:$('#form5').serializeArray(),
                success:function(data){
                    console.log(data);
                    var serializeJson = $('#form5').serializeArray();
                    console.log(JSON.stringify(serializeJson));
                    alert('提交成功');
                },
                false:function(data){
                    alert('提交失败');
                }
            });
            $('.userInfo').hide();
        }
    });
    $('#cancel').click(function(){
        $('.userInfo').hide();
    }	);
});
$('#btnconfirm').click(function(){
    var val=$('input:radio[name="authority"]:checked').val();
    if(val==null){
        alert("请选择其中一项");
        return false;
    }
    else{
        $.ajax({
            dataType:'json',
            url:'UserInformation.java',
            data:{name:val},
            type:'get',
            success:function(data){
                console.log(val);
                alert('设置成功');
            }
        })
    }
});
$('#btncancel').click(function(){
    $('.authoritySet').hide();
});
$.ajax({
    type:"post",
    url:"../../../java/com/bupt317/study/lab_manager/pojo/mybatis/UserInformation.java",
    dataType:"json",
    success:function(data){
        console.log(data);
        $('#user_name').val(user_name);
    }
});
var  user='';
var user_list=[
    {
        stu_name:'张三',
        sex:'',
        sutdentid:'2018140822',
        teacher_name:'',
        major_name:'',
        class_num:'',
        beizhu:'',
        id:'',
    },
    {
        stu_name:'张三',
        sex:'',
        sutdentid:'2018140822',
        teacher_name:'',
        major_name:'',
        class_num:'',
        beizhu:'',
        id:'',
    },
    {
        stu_name:'张三',
        sex:'',
        sutdentid:'2018140822',
        teacher_name:'',
        major_name:'',
        class_num:'',
        beizhu:'',
        id:'',
    },
    {
        stu_name:'张三',
        sex:'',
        sutdentid:'2018140822',
        teacher_name:'',
        major_name:'',
        class_num:'',
        beizhu:'',
        id:'',
    },
];
