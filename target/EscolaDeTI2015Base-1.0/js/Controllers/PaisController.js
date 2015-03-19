/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var module = angular.module("Pais", []);

    module.service("paisService", function ($http){
        
        var url = "/paises";
        
        this.list = function(){
            return $http.get(url);
        };
        
        this.save = function(pais){
            return $http.post(url, pais);
        };
        
        this.remove = function(id){
            return $http.delete(url +'/'+ id);
        };
        
        this.getById = function(id){
            return $http.get(url + '/' + id);
        };
        
        this.edit = function(pais){
            return $http.put(url +'/'+ pais.id, pais);
        };
    });

    module.controller("PaisController", function ($scope, paisService, $location, $routeParams){
        
        $scope.paises = [];
        $scope.update = false;
        
        $scope.atualizar = function(){
            $scope.pais = {};
            
            paisService.list().success(function(data){
                $scope.paises = data;
                console.log($scope.paises);
            }).error(function(){
                console.log("Não funfou!!!");
            });
        };
        
        $scope.cadastrar = function(pais){
            console.log(pais);
            
            if (!$scope.update){
                paisService.save(pais).success(function(data){
                   $location.path("/paises");
                }).error(function(){
                    console.log("Não cadastrou!!!");
                });
            }else{
                paisService.edit(pais).success(function(data){
                    $location.path("/paises");
                   $scope.update = false;
                }).error(function(){
                    console.log("Não cadastrou!!!");
                });
            }
        }; 
        
        $scope.excluir = function(pais){
            paisService.remove(pais.id).success(function(){
                $scope.atualizar();
            }).error(function(){
               console.log("Não excluiu!!!!");
            });
        };
        
        if ($routeParams.id){
            var id = $routeParams.id;        
            paisService.getById(id).success(function(data){
                $scope.pais = data;               
                $scope.update = true;
            }).error(function(){
                console.log("Não funfou!!!");
            });
        }
    });

