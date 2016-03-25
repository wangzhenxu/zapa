<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>获取坐标信息</title>
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css"/>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=a788539c529d82e25bbc19023317f781"></script>		
<script src="/js/jquery/jquery.js"></script>
<script src="/js/gaodeMap.js"></script>
<script src="/js/areaCoordInfo.js"></script>
<script  language="javascript">	
   $(function(){
	  var coords=${coordListJson};
	  getCoordInfo(coords);
	  //setLgltInfo("北京市海淀区图书城东南侧彩和坊路8号");
   });
     
</script>
</head>

<body>
   <div id="coordInfo">
   </div>
</body>
</html>