
/**   
*   集合类   
**/
var Collection = Array;   
        
      //添加元素   
Collection.prototype.Add = function (e) {
	this[this.length++] = e;
};   
        
      //集合尺寸   
Collection.prototype.Length = function () {
	return this.length;
};   
        
      //取得某个元素   
Collection.prototype.Element = function (i) {
	return this[i];
};
Collection.prototype.Delete = function (dx) {
	if(isNaN(dx)||dx>this.length){return false;}
		for(var i=0,n=0;i<this.length;i++)
		{
			if(this[i]!=this[dx])
			{
				this[n++]=this[i];
			}
		}
		this.length-=1;
};
        
      //删除某个子集合   
Collection.prototype.DeleteAll = function (c) {
	for (var i = 0; i < c.length; i++) {
		this.Delete(c[i]);
	}
};   
    
      //集合排序，mode为升序或者降序   
Collection.prototype.Sort = function (mode) {
	this.sort();
};   
    
      //查找某个元素   
Collection.prototype.Search = function (e) {
	for (var i = 0; i < this.length - 1 && this[i] != e; i++) {
	}
	if (i == this.length - 1) {
		return null;
	} else {
		return i + 1;
	}
};   
    
      //判断集合是否为空   
Collection.prototype.isEmpty = function () {
	return this.length == 0 ? true : false;
};   
        
      //将另一个集合赋给此集合   
Collection.prototype.AddAll = function (c) {
	for (var i = 0; i < c.length; i++) {
		this.Add(c[i]);
	}
};   
        
      //清空集合   
Collection.prototype.Clear = function () {
	this.length = 0;
};   
        
      //将元素添加到集合的某个位置   
Collection.prototype.AddToPos = function (e, pos) {
	this.length++;
	for (var i = this.length - 1; i > pos - 1; i--) {
		this[i] = this[i - 1];
	}
	this[pos] = e;
};   
    
      //将集合元素顺序颠倒   
Collection.prototype.Reverse = function () {
	this.reverse();
};   
        
      //打印所有元素   
Collection.prototype.PrintAll = function () {
	var all = "";
	for (var i = 0; i < this.length; i++) {
		all += this[i] + ";";
	}
	return all;
};   
        
      //比较两个集合是否相等   
Collection.prototype.Equals = function (e) {
	if (this.length != e.length) {
		return false;
	}
	for (var i = 0; (i < this.length) && (this[i] == e[i]); i++) {
	}
	return i == (this.length) ? true : false;
};   
    
      //更新某个元素的值   
Collection.prototype.SetValue = function (value, pos) {
	this[pos] = value;
};

