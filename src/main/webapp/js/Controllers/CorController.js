/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var module = angular.module("Cor", []);

    module.service("CorService", function ($http){
        
        var url = "/cores";
        
        this.list = function(){
            return $http.get(url);
        };
        
        this.save = function(cor){
            return $http.post(url, cor);
        };
        
        this.remove = function(id){
            return $http.delete(url +'/'+ id);
        };
        
        this.getById = function(id){
            return $http.get(url + '/' + id);
        };
        
        this.edit = function(cor){
            return $http.put(url +'/'+ cor.id, cor);
        };
    });

    module.controller("CorController", function ($scope, CorService, $location, $routeParams){
        
        $scope.cores = [];
        $scope.update = false;
        
        $scope.atualizarCores = function(){
            $scope.cor = {};
            CorService.list().success(function(data){
                $scope.cores = data;
                console.log($scope.cores);
            }).error(function(){
                console.log("Não funfou!!!");
            });
        };
        
        $scope.cadastrar = function(cor){
            console.log($scope.cor);
            if (!$scope.update){
                CorService.save(cor).success(function(data){
                  $location.path("/cores");
                }).error(function(){
                    console.log("Não cadastrou!!!");
                });
            }else{
                CorService.edit(cor).success(function(data){
                   $location.path("/cores");
                   $scope.update = false;
                }).error(function(){
                    console.log("Não cadastrou!!!");
                });
            }
        }; 
        
        $scope.excluir = function(cor){
            CorService.remove(cor.id).success(function(){
                $scope.atualizarCores();
            }).error(function(){
               console.log("Não excluiu!!!!");
            });
        };
        
        if ($routeParams.id){
            var id = $routeParams.id;
            console.log(id);
            CorService.getById(id).success(function(data){                
                $scope.cor = data;                
                $scope.update = true;
            }).error(function(){
                console.log("Não funfou!!!");
            });
        }
    });

