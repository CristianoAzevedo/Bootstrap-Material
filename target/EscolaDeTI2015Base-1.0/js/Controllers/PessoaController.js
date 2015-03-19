 var modulo = angular.module('Pessoa', []);
 
 modulo.service('pessoaService', function($http){
    
    var url = '/pessoas';
    
    this.list = function(){
        return $http.get(url);
    };
    
    this.save = function(p){
        return $http.post(url,p);
    };
    
    this.remove = function(id){
        return $http.delete(url + '/' + id);
    };
    
    this.edit = function(p){
        return $http.put(url + '/' + p.id, p);
    };
    
    this.getById = function(id){
        return $http.get(url + '/' + id);
    };
 });
    modulo.controller('PessoaController', function($scope, pessoaService, $location, $routeParams){
        
        $scope.pessoas = [];      
        
        $scope.atualizarPessoa = function(){
            $scope.update = false;
            $scope.pessoa = {};
            pessoaService.list().success(function(data){
                $scope.pessoas = data;
            }).error(function(){
                console.log("Deu erro.");
            });
        };
        
        $scope.excluir = function(p){
            pessoaService.remove(p.id).success(function(){
                $scope.atualizarPessoa();
            }).error(function(){
                console.log("Deu erro.");
            });
        };
        
        if ($routeParams.id){
            var id = $routeParams.id;
            pessoaService.getById(id).success(function(data){
                $scope.pessoa = data;               
                $scope.update = true;
            }).error(function(){
                console.log("Deu erro.");
            });
        }
        
        $scope.cadastrar = function(p){
            if(!$scope.update){
                pessoaService.save(p).success(function(data){
                   $location.path("/pessoas");
                }).error(function(){
                    console.log("Não salvou");
                });
            }else{
                pessoaService.edit(p).success(function(data){
                    $location.path("/pessoas");
                }).error(function(){
                    console.log('Não editou!');
                });
            }
        };
 });

