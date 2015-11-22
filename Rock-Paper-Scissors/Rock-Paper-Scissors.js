Tasks = new Mongo.Collection("entries9");
 
Router.route('/', function () {
  this.render('task');
});

Router.route('/player1');

Router.route('/player2');
 
if (Meteor.isClient) {
  // This code only runs on the client
  
  Template.player1.helpers({
	text: function(){
		p1 = Tasks.find({player: 1}).fetch()[0];
		p2 = Tasks.find({player: 2}).fetch()[0];
		if((typeof p1 === 'undefined') || p1.choice == "none") {
			return 'Click your choice';
		} else if((typeof p2 === 'undefined') || p2.choice == "none"){
		   	return "waiting for player2";
		} else {
			p1 = p1.choice;
			p2 = p2.choice;
			out1 = "you win!";
			out2 = "you lose!";
			if(p1 == "rock" && p2 == "paper") {
				return out2;
			} else if(p1 == "paper" && p2 == "rock") {
				return out1;
			} else if(p1 == "scissors" && p2 == "rock") {
				return out2;
			} else if(p1 == "scissors" && p2 == "paper") {
				return out1;
			} else if(p1 == "rock" && p2 == "scissors") {
				return out1;
			} else if(p1 == "paper" && p2 == "scissors") {
				return out2;
			} else {
				return "you tie";
			}
		} 	
	},
	color1: function(){
	  if(Tasks.find({player: 1}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 1}).fetch()[0].choice == "rock") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	},
	color2: function(){
	  if(Tasks.find({player: 1}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 1}).fetch()[0].choice == "paper") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	},
	color3: function(){
	  if(Tasks.find({player: 1}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 1}).fetch()[0].choice == "scissors") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	}
  });
  
  Template.player2.helpers({
	text: function(){
		p1 = Tasks.find({player: 1}).fetch()[0];
		p2 = Tasks.find({player: 2}).fetch()[0];
		if((typeof p2 === 'undefined') || p2.choice == "none") {
			return 'Click your choice';
		} else if((typeof p1 === 'undefined') || p1.choice == "none"){
		   	return "waiting for player1";
		} else {
			p1 = p1.choice;
			p2 = p2.choice;
			out2 = "you win!";
			out1 = "you lose!";
			if(p1 == "rock" && p2 == "paper") {
				return out2;
			} else if(p1 == "paper" && p2 == "rock") {
				return out1;
			} else if(p1 == "scissors" && p2 == "rock") {
				return out2;
			} else if(p1 == "scissors" && p2 == "paper") {
				return out1;
			} else if(p1 == "rock" && p2 == "scissors") {
				return out1;
			} else if(p1 == "paper" && p2 == "scissors") {
				return out2;
			} else {
				return "you tie";
			}
		} 	
	},
	color1: function(){
	  if(Tasks.find({player: 2}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 2}).fetch()[0].choice == "rock") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	},
	color2: function(){
	  if(Tasks.find({player: 2}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 2}).fetch()[0].choice == "paper") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	},
	color3: function(){
	  if(Tasks.find({player: 2}).count() == 0) {
	  return "hide-completed";
	} else {
		if(Tasks.find({player: 2}).fetch()[0].choice == "scissors") {
			return "hide-ready";
		} else {
			return "hide-completed";
		}
	}		
	}
  });
 
  Template.player1.events({
    "click .hide-completed": function (event) {
	if(Tasks.find({player: 1}).count() == 0) {
		Tasks.insert({
		player: 1,
		choice: event.target.innerHTML,
        createdAt: new Date() // current time
        });
	} else {
		Tasks.update(Tasks.find({player: 1}).fetch()[0]._id, {
        $set: {choice: event.target.innerHTML}
      });
	  }
	},
	"click .resetScore": function (event) {
		console.log("clicked");
		Tasks.update(Tasks.find({player: 1}).fetch()[0]._id, {
        $set: {choice: "none"}
      });
	  Tasks.update(Tasks.find({player: 2}).fetch()[0]._id, {
        $set: {choice: "none"}
      });
	}
  });
  
  Template.player2.events({
    "click .hide-completed": function (event) {
	if(Tasks.find({player: 2}).count() == 0) {
		Tasks.insert({
		player: 2,
		choice: event.target.innerHTML,
        createdAt: new Date() // current time
        });
	} else {
		 Tasks.update(Tasks.find({player: 2}).fetch()[0]._id, {
        $set: {choice: event.target.innerHTML}
      });
	  }
	},
	"click .resetScore": function (event) {
		console.log("clicked");
		Tasks.update(Tasks.find({player: 1}).fetch()[0]._id, {
        $set: {choice: "none"}
      });
	  Tasks.update(Tasks.find({player: 2}).fetch()[0]._id, {
        $set: {choice: "none"}
      });
	}
  });
 
 
}