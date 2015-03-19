var modulo = angular.module('App',['ngRoute', 'Cor', 'Pais', 'Pessoa', 'angular-loading-bar']);

	/*
	 * criando as rotas
	 */

	modulo.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider){
		
		$routeProvider
				
			/*
			 * rotas para o controller cores
			 */
			.when('/cores',{
				templateUrl: 'views/cores.html',
				controller: 'CorController'
			})
			
			.when('/cores/manter-cor/',{
				templateUrl: 'views/manter-cor.html',
				controller: 'CorController'
			})
                        
			.when('/cores/manter-cor/:id',{
				templateUrl: 'views/manter-cor.html',
				controller: 'CorController'
			})
			
			/*
			 * rotas para o controller pais
			 */
			
			.when('/paises',{
				templateUrl: 'views/paises.html',
				controller: 'PaisController'
			})
                        
			.when('/paises/manter-pais/',{
				templateUrl: 'views/manter-pais.html',
				controller: 'PaisController'
			})
                        
			.when('/paises/manter-pais/:id',{
				templateUrl: 'views/manter-pais.html',
				controller: 'PaisController'
			})
                        
                        /*
                         * rotas para o controller pessoas
                         */
                        
                        .when('/pessoas',{
                                templateUrl: 'views/pessoas.html',
                                controller: 'PessoaController'
                        })
                        
                        .when('/pessoas/manter-pessoa/',{
                                templateUrl: 'views/manter-pessoa.html',
                                controller: 'PessoaController'
                        })
                        
                        .when('/pessoas/manter-pessoa/:id',{
                                templateUrl: 'views/manter-pessoa.html',
                                controller: 'PessoaController'
                        })
			// caso não exista a rota, redireciona para a rota '/'
			.otherwise ({ redirectTo: '/' });
                
                         $locationProvider.html5Mode(false);
                         
		
	}]);