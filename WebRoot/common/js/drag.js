var isIE = (document.all) ? true : false;

var $ = function (id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};

var Class = {
	create: function() {
		return function() { this.initialize.apply(this, arguments); }
	}
}

var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
}

var Bind = function(object, fun) {
	return function() {
		return fun.apply(object, arguments);
	}
}

var BindAsEventListener = function(object, fun) {
	return function(event) {
		return fun.call(object, (event || window.event));
	}
}

function addEventHandler(oTarget, sEventType, fnHandler) {
	if (oTarget.addEventListener) {
		oTarget.addEventListener(sEventType, fnHandler, false);
	} else if (oTarget.attachEvent) {
		oTarget.attachEvent("on" + sEventType, fnHandler);
	} else {
		oTarget["on" + sEventType] = fnHandler;
	}
};

function removeEventHandler(oTarget, sEventType, fnHandler) {
    if (oTarget.removeEventListener) {
        oTarget.removeEventListener(sEventType, fnHandler, false);
    } else if (oTarget.detachEvent) {
        oTarget.detachEvent("on" + sEventType, fnHandler);
    } else { 
        oTarget["on" + sEventType] = null;
    }
};

//拖放程序
var SimpleDrag = Class.create();
SimpleDrag.prototype = {
  //拖放对象,触发对象
  initialize: function(drag) {
	this.Drag = $(drag);
	this._x = this._y = 0;
	this._fM = BindAsEventListener(this, this.Move);
	this._fS = Bind(this, this.Stop);
	this.Drag.style.position = "absolute";
	addEventHandler(this.Drag, "mousedown", BindAsEventListener(this, this.Start));
  },
  //准备拖动
  Start: function(oEvent) {
	this._x = oEvent.clientX - this.Drag.offsetLeft;
	this._y = oEvent.clientY - this.Drag.offsetTop;
	addEventHandler(document, "mousemove", this._fM);
	addEventHandler(document, "mouseup", this._fS);
  },
  //拖动
  Move: function(oEvent) {
	this.Drag.style.left = oEvent.clientX - this._x + "px";
	this.Drag.style.top = oEvent.clientY - this._y + "px";
  },
  //停止拖动
  Stop: function() {
	removeEventHandler(document, "mousemove", this._fM);
	removeEventHandler(document, "mouseup", this._fS);
  }
};
