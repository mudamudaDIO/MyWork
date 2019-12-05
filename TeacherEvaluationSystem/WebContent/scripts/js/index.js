//  点击对应的li标签 其他的div隐藏
$(function(){
	$(".t_left_ul>ul>li").click(function(){
		$(this).children(".t_left_ul_2").show().parent().siblings(".li1").children(".t_left_ul_2").hide();
	})
})