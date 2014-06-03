$(function(){
  // --- Initialize scriptTree Dynatree -------------------------------------------
  $("#tree").dynatree({
	  	title : "ScriptTree",
	  	fx: { height: "toggle", duration: 200 },
		selectMode : 3,
		minExpandLevel : 1,
		children: [ 
		   {title: "ScriptsWS", 
			isFolder: true
		    }
        ],
	    dnd: {
	      preventVoidMoves: true,
	      onDragStart: function(node) {
	        return true;
	      },
	      onDragEnter: function(node, sourceNode) {
	        if(node.parent !== sourceNode.parent){
	          return false;
	        }
	        return ["before", "after"];
	      },
	      onDrop: function(node, sourceNode, hitMode, ui, draggable) {
	        sourceNode.move(node, hitMode);
	      }
	    }
		
	  });
});