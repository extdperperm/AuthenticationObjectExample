        @GetMapping(value= {"/","/index"})
	public String idx(Model objModel, Authentication authentication) {
		String Roles = "";
		
		//Si el usuario dispone de roles se procede a obtenerlos.
		if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
			 GrantedAuthority auxRol;
			 //Se obtiene la colección de roles del usuario
			 Collection<? extends GrantedAuthority> objRoles = authentication.getAuthorities();
			 //Se prepara para iterar la colección
			 Iterator<? extends GrantedAuthority> iterator = objRoles.iterator();
			 
		        //Se itera recorriendo todos los roles que pudiera disponer el usuario
		        while (iterator.hasNext()) {
		        	auxRol = iterator.next();
		        	Roles = Roles + auxRol.getAuthority() + ", ";
		        } 
		}
		
		//Se obtienen datos de autenticación como el nombre. Todos los datos se asignan al modelo de spring
		//para mostrar la información en las vistas.
		objModel.addAttribute("Nombre", authentication.getName());
		objModel.addAttribute("Roles", Roles);
		
		return "index";
	}