<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/newecsite.css"/>
<title>BuyItemConfirm画面</title>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action', url);
		$('form').submit();
		}
</script>

</head>
<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:form>
				<tr>
					<td>商品名</td>
					<td><s:property value="session.buyItem_name" /></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><s:property value="session.total_price" /><span>円</span></td>
				</tr>
				<tr>
					<td>購入個数</td>
					<td><s:property value="session.count" /><span>個</span></td>
				</tr>
				<tr>
					<td>支払い方法</td>
					<td><s:property value="session.pay" /></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="button" value="戻る"onclick="submitAction('HomeAction')" /></td>
					<td><input type="button" value="完了"onclick="submitAction('BuyItemConfirmAction')" /></td>
				</tr>
			</s:form>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>