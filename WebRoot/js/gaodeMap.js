var gmap = {

}

var marker = new Array();
var windowsArr = new Array();
var map = new AMap.Map("mapContainer", {
    resizeEnable: true
});
function geocoder(address,geocoder_callBack) {
    var MGeocoder;
    //加载地理编码插件
    AMap.service(["AMap.Geocoder"], function() {
        MGeocoder = new AMap.Geocoder({
            city: "010", //城市，默认：“全国”
            radius: 1000 //范围，默认：500
        });
        //返回地理编码结果
        //地理编码
        MGeocoder.getLocation(address, geocoder_callBack);
    });
}
function addmarker(i, d) {
    var lngX = d.location.getLng();
    var latY = d.location.getLat();
    var markerOption = {
        map: map,
        icon:"http://webapi.amap.com/theme/v1.3/markers/n/mark_b"+(i+1)+".png",
        position: [lngX, latY]
    };
    var mar = new AMap.Marker(markerOption);
    marker.push([lngX, latY]);

    var infoWindow = new AMap.InfoWindow({
        content: d.formattedAddress,
        autoMove: true,
        size: new AMap.Size(150, 0),
        offset: {x: 0, y: -30}
    });
    windowsArr.push(infoWindow);

    var aa = function(e) {
        infoWindow.open(map, mar.getPosition());
    };
    mar.on( "mouseover", aa);
}
//地理编码返回结果展示
function geocoder_CallBack(data) {
    var resultStr = "";
    //地理编码结果数组
    var geocode = new Array();
    geocode = data.geocodes;
    for (var i = 0; i < geocode.length; i++) {
        //拼接输出html
        resultStr += "<span style=\"padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\">" + 
                     "<b>地址</b>：" + geocode[i].formattedAddress + "" + "<b><br/>坐标</b>：" + 
                      geocode[i].location.getLng() + ", " + geocode[i].location.getLat() + "" + 
                      "<b><br/>匹配级别</b>：" + geocode[i].level + "</span>";
        addmarker(i, geocode[i]);
    }
    map.setFitView();
    document.getElementById("result").innerHTML = resultStr;
}