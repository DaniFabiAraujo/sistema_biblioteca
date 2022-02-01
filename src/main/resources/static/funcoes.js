function eliminarLivro(id) {
	console.log(id);
	swal({
		  title: "Deseja eliminar esse registro? ",
		  text: "Uma vez eliminado não é possível reestabelecê-lo",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/gerenciar/livros/excluir/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Registro eliminado com sucesso!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/gerenciar/livros";
		    	}
		    });
		  } 
		});
}

function eliminarUsuario(id) {
	console.log(id);
	swal({
		  title: "Deseja eliminar esse registro? ",
		  text: "Uma vez eliminado não é possível reestabelecê-lo",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/gerenciar/usuarios/excluir/"+id,
				 success: function(res) {
					console.log(res);
				},			
			  });
		    swal("Registro eliminado com sucesso!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/gerenciar/usuarios";
		    	}
		    });
		  } 
		});
}


