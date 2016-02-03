var array = new Array();
function getCoordInfo(coords){
	//alert(coords);
	for(i in coords){
		setLgltInfo(coords[i]);
	}
	
	setTimeout(function(){
		$("#coordInfo").html(JSON.stringify(array));
	},5000); 
	//setLgltInfo();
}  


function setLgltInfo(obj){
		var self =this
	
		geocoder(obj.hdLocation,function(status, result){
			if (status === 'complete' && result.info === 'OK')
			{
				  var geocode = new Array();
				    geocode = result.geocodes;
				   
				    for (var i = 0; i < geocode.length; i++) {
				        
				        var areaName = geocode[i].addressComponent.district;
				        var areaName=areaName.replace("区","");
					   
					    var newObj = new Object();
					    newObj.hdLocation=obj.hdLocation;
					    newObj.hdPositionId=obj.hdPositionId;
					    newObj.coordX= geocode[i].location.getLng();
					    newObj.coordY= geocode[i].location.getLat();
					    newObj.areaName = areaName;
				    	array.push(newObj);
					    
					    /*$("input[name=areaId]").each(function(){
					    	if($(this).attr("tempAreaName")==areaName){
					    		$(this).attr("checked",true);
					    	}
					    });*/
					    //$("#coordInfo").html(coordX+coordY+areaName);
				    }
            }else 
        	if(status === 'no_data'){
        		alert("nodata");
        		/*self.coordX.val("");
    			self.coordY.val("");*/
    			//common.alert("工作地点无效");
				return;
            }
		});
 }