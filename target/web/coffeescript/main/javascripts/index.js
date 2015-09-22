(function() {
  $(function() {
    return $.get("/persons", function(persons) {
      return $.each(persons, function(index, person) {
        var age, name;
        name = $("<div>").addClass("name").text(person.name);
        age = $("<div>").addClass("age").text(person.age);
        return $("#persons").append($("<li>").append(name).append(age));
      });
    });
  });

}).call(this);

//# sourceMappingURL=index.js.map
