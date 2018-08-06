<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content="no"/>
	<meta name="keywords" content=""/>
	<title>Home画面</title>

<style type="text/css">
body{
	margin:0;
	padding:0;
	line-height:1.6;
	letter-spacing:1px;
	font-family:Verdana,Helvetica,sans-serif;
	font-size:12px;
	color:#333;
	background:#fff;
}
table{
	text-align:center;
	margin:0 auto;
}
#top{
	width:100%;
	margin:30px auto;
	border:1px solid #333;
}
#header{
	width:100%;
	height:80px;
	background-color:black;
}
#main{
	width:100%;
	height:500px;
	text-align:center;
}
#footer{
	width:100%;
	height:80px;
	background-color:black;
	clear:both;
}
#text-center{
	display:inline-block;
	text-align:center;
}

.bluelight {
    display: table;
    width: 200px;
    height: 200px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    a {
        display: table-cell;
        font-size: 3em;
        text-decoration: none;
        text-align: center;
        vertical-align: middle;
        border-radius: 50%;
        transition: background 1s, border-width 0.5s cubic-bezier(0.075, 0.820, 0.165, 1.000), text-shadow 0.5s;
        color: #daf6ff;
        text-shadow: 0 0 20px rgba(10, 175, 230, 1),  0 0 20px rgba(10, 175, 230, 0);
        box-shadow: 0 0 0 rgba(10, 175, 230, 0),  inset 0 0 0 rgba(10, 175, 230, 0);
        background-image: radial-gradient(center, ellipse cover, rgba(10, 175, 230, 0) 0%, rgba(10, 175, 230, 0) 90%);
        border: 0 dotted rgba(10, 175, 230, 0.0);
        &:hover {
            color: #fff;
            text-shadow: 0 0 50px rgba(10, 175, 230, 1),  0 0 50px rgba(10, 175, 230, 1);
            background-image: radial-gradient(center, ellipse cover, rgba(10, 175, 230, 0.3) 0%, rgba(10, 175, 230, 0) 60%);
        }
    }
    &:before, &:after, a:before, a:after {
        transition: 0.2s ease-in-out;
        content: "";
        display: block;
        position: absolute;
        border-radius: 50%;
        border: 60px dashed transparent;
        left: 50%;
        top: 50%;
        transform : translate(-50%,-50%);
    }
    &:before {
        animation: rotate 20s linear 0s infinite;
        width: 180%;
        height: 180%;
        border: 3px dotted rgba(10, 175, 230, 0);
        z-index: -1;
    }
    &:after {
        animation: rotate 10s linear 0s infinite reverse;
        border: 80px dashed rgba(10, 175, 230, 0);
        width: 160%;
        height: 160%;
        z-index: -2;
    }
    a {
        &:before {
            animation: rotate 5s ease-in-out 0s infinite alternate;
            width: 120%;
            height: 120%;
            border: 50px dashed rgba(10, 175, 230, 0);
        }
        &:after {
            animation: rotate 5s linear 0s infinite;
            border: 18px dashed rgba(10, 175, 230, 0);
            width: 120%;
            height: 120%;
        }
    }
    &:hover {
        &:before {
            border-color: rgba(10, 175, 230, 0.3);
        }
        &:after {
            border-color: rgba(10, 175, 230, 0.1);
        }
        a {
            &:before {
                border-color: rgba(10, 175, 230, 0.3);
            }
            &:after {
                border-color: rgba(10, 175, 230, 0.3);
            }
        }
    }
}
@keyframes rotate {
    0% {
        transform: translate(-50%,-50%) rotate(0deg);
    }
    100% {
        transform: translate(-50%,-50%) rotate(360deg);
    }
}
p.caption {
    font-size: 0.7em;
    text-align: center;
    position: fixed;
    width: 100%;
    bottom: 0;
    letter-spacing: 0.2em;
    text-shadow: 0 0 20px rgba(10, 175, 230, 1),  0 0 20px rgba(10, 175, 230, 0);
}

</style>

</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
	<div class="bluelight">
    <a href="#">HOVER</a>
</div>
<p class="caption">BLUE LIGHT BUTTON</p>
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入"/>
			</s:form>
			<s:if test="#session.id!=null">
				<p>ログアウトする場合は
					<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
			</s:if>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>