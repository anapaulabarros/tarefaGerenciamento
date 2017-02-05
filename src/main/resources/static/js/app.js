$(document).ready(function() {
	$("#categoria").change(function(){          
	    var valor = $("#categoria option:selected").val();
	    if(valor === 'outra'){
	    	$("#input-categoria").slideDown().removeClass("hidden-input");
		    $("#categoria option:selected").attr('disabled','disabled');
	    }
	});
	orderingDataTable();
});

function changeSizeFont(option){
    if(option == 'plus'){
        $('*').css({"font-size":"17px"});
    }
    if(option == 'minus'){
        $('*').css({"font-size":"13px"});
    }
}


function changeBackGroundColour(){
    $('body').css({"background":"#ddd"});
}

function restoreSettings(){
	$('body').css({"background":"#fafafa"});
	$('*').css({"font-size":"14px"});
}

function addInput(){
	var divConteudo = $('#boxInput');
	var conteudoHTML = '<input name="listaSubTarefas" th:value="${tarefa.listaSubTarefas}" class="form-control input-sub" id="listaSubTarefas" placeholder="Descreva a subTarefa..."/>';
	$(conteudoHTML).appendTo(divConteudo);
}


function orderingDataTable(){
	var table = $('#tabela-tarefas-abertas');
	
	$('#nome, #prioridade')
    .wrapInner('<span title="Ordernar por essa coluna"/>')
    .each(function(){
        
        var th = $(this),
            thIndex = th.index(),
            inverse = false;
        
        th.click(function(){
            
            table.find('td').filter(function(){
                
                return $(this).index() === thIndex;
                
            }).sortElements(function(a, b){
                
                return $.text([a]) > $.text([b]) ?
                    inverse ? -1 : 1
                    : inverse ? 1 : -1;
                
            }, function(){
                
                // parentNode is the element we want to move
                return this.parentNode; 
                
            });
            
            inverse = !inverse;
                
        });
            
    });
}