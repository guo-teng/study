
    let feiyongbaoxiao = document.querySelector('.feiyongbaoxiao');
    let baoxiaoyilan = document.querySelector('.baoxiaoyilan');
    let feiyongshenhe = document.querySelector('.feiyongshenhe');

    function show(num){
        if(num ==0){
            feiyongbaoxiao.style.display = 'block';
            baoxiaoyilan.style.display = 'none';
            feiyongshenhe.style.display = 'none';
        }
        else if(num ==1){
            feiyongbaoxiao.style.display = 'none';
            baoxiaoyilan.style.display = 'block';
            feiyongshenhe.style.display = 'none';
        }
        else if(num==2){
            feiyongbaoxiao.style.display = 'none';
            baoxiaoyilan.style.display = 'none';
            feiyongshenhe.style.display = 'block';
        }
    };
    $(function(){
        $('#submit').click(function() {
            var d = [];
            var t = $('#form1').serializeArray();
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
                alert("请填写报销类别");
                return false;
            }
            else if(i == 1) {
                alert("请填写付款方式");
                return false;
            }
            else if(i == 2) {
                alert("请填写买卖双方");
                return false;
            }
            else if(i == 3) {
                alert("请选择时间");
                return false;
            }
            else if(i== 4) {
                alert("请填写报销状态");
                return false;
            }
            else if(i == 5) {
                alert("请填写具体内容");
                return false;
            }
            else{
                $.ajax({
                    url:"../1.js",
                    type:"post",
                    data:$('#form1').serialize(),
                    dataType:"json",
                    error:function(data){
                        // alert(data);
                        console.log(data);
                        alert("提交失败");
                        return false;
                    },
                    success:function(data){
                        // alert(data);
                        console.log(data);
                        $('#form1').empty();
                        alert("提交成功");
                    }
                });
            }
        });
    });
    var   claimInput='';
    $(
        function(){
            $('#shaixuan').click(function(){
                $.ajax({
                    url:"../1.js",
                    type:"post",
                    dataType:"json",
                    data:$('.form2').serialize(),
                    success:function(data){
                        console.log(data);
                        for(item in data){
                            claimInput+=`<tr>
                                            <td>
                                              姓名：<input type="text" value="${data[item].name}" disabled="true">
                                             </td>
                                            <td>
                                               报销单号：<input type="text" value="${data[item].claimNum}" disabled="true">
                                             </td>
                                         </tr>`
                        };
                    }
                });
             });
            $('.form2  table ').after(claimInput);
        }
    );
    var   claimList='';
    $(
        function(){
            $('#chaxun').click(function(){
                console.log(1);
                $.ajax({
                    url:"../1.js",
                    type:"post",
                    dataType:"json",
                    success:function(data){
                        console.log(data);
                        for(itemList in data){
                            claimList+=`<tr>
                                          <td>
                                            姓名：<input type="text" name="baoxiaodan" value="${data[itemList].name}" disabled="true">
                                          </td>
                                           <td>
                                             报销单号：<input type="text" name="baoxiaodan" value="${data[itemList].claimListNum}" disabled="true">
                                           </td>
                                           <td>
                                             <button type="button" name="confirm">确认</button>
                                           </td>
                                           <td>
                                               <button type="button" name="delete">删除</button>
                                           </td>
                                           <td>
                                               <button type="button" name="change">修改</button>
                                           </td>
                                          </tr>`
                        };
                    }
                });
            });
        $('.form3  table tr').after(claimList);
        }
    );
