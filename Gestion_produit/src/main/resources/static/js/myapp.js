
var app=angular.module("app",[]);
app.controller("appcontroller", function($scope,$http) {
	$scope.produits=[];
	$scope.categories=[];
	 $scope.selectedcategory=null;
	$scope.motcle=null;
	$scope.pagecourant=0;
	$scope.pages=[];
 
	
	$scope.category={};
    $scope.produit= {
    		designation : "",
    		  prix : "",
    		  
    		   };
    
 
    $http.get("/allcat")
	  .then(function(response){
		    $scope.categories = response.data;
		 
		  });
    
    
    $http.get("/pageproduits?page="+$scope.pagecourant)
	  .then(function(response){
		    $scope.produits = response.data;
		    $scope.pages = new Array(response.data.totalPages);
		  });
    
    
    $scope.chargercategories=function(){
  	  $http.get("/allcat")
  	  .then(function(response){
  		    $scope.categories = response.data;
  		 
  		  });
  	  
  	  };
    
		
	  
	  
	  $scope.chargerproduitsparcat=function(){
		  $http.get("/produitsparcat?page="+$scope.pagecourant+"&idcategory="+$scope.category)
		  .then(function(response){
			    $scope.produits = response.data;
			    $scope.pages = new Array(response.data.totalPages);
			  });
		  
		  };
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  $scope.charger=function(){
	  $http.get("/pageproduits?page="+$scope.pagecourant)
	  .then(function(response){
		    $scope.produits = response.data;
		    $scope.pages = new Array(response.data.totalPages);
		  });
	  
	  };
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  $scope.chargerproduit=function(){
	
		
			  $http.get("/produitmc?mc="+$scope.motcle+"&page="+$scope.pagecourant)
			  .then(function(response){
				    $scope.produits = response.data;
				    $scope.pages = new Array(response.data.totalPages);
				  });
			
			
		};
	
	
	
   $scope.gopage=function(p){
	   $scope.pagecourant=p;
	
	   $scope.charger();
   };
   
   
   $scope.gourl=function(){
	   $scope.pagecourant=0;
	
	  $scope.chargerproduitsparcat();
   };
   
   
   $scope.clearform=function(p){
	   $scope.produit= {
	    		designation : "",
	    		  prix : ""
	    		   };
   };
   
			
		
   $scope.deleteproduit=function(id){
	  
	    $http.delete("/delete?ref="+id)
	    .then(function(response){
	    	  $scope.charger();
		  });
	   
   };
   
   
   

  
  
  
  $scope.add = function() 
  {
	 
	  
    $http({
    method : 'POST',
    url : 'save',
    data : angular.toJson($scope.produit),
    headers : {
    'Content-Type' : 'application/json'
    }
    }).then(function(response){
	  $scope.chargerproduit();
	  $scope.clearform();
	  });
    
  }
  
  
  
  
  


});
	
	
	
	
	
	
	
	
	
	
	


