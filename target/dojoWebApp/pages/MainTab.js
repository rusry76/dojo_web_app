define([
    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/on",
    "dojo/json",
    "dijit/layout/ContentPane",
    "dojo/store/JsonRest",
    "dojo/data/ObjectStore",
    "pages/TabFactory",
    "dijit/registry",
    "dijit/form/Button",
    "gridx/Grid",
    "gridx/core/model/cache/Async",
    "gridx/modules/SingleSort",
    "gridx/modules/ColumnResizer",
    "gridx/core/model/extensions/FormatSort",
], function(
    declare,
    lang,
    on,
    JSON,
    ContentPane,
    JsonRest,
    ObjectStore,
    TabFactory,
    registry,
    Button,
    Grid,
    Async,
    SingleSort,
    Resizer,
    FormatSort
){
    return declare("MainTab", [ContentPane], {
        title: null,
        grid: null,

        postMixInProperties: function(){
            this.inherited(arguments);
            this.title = "Employees";
        },

        postCreate: function() {
            this.addChild(this._createGrid());
            this.addChild(this._createAddBtn());
            this.addChild(this._createRefreshBtn());
        },

        _createGrid: function() {
            var myStore = new JsonRest({
                idProperty: "id",
                target: "/dojoWebApp/api/ecm/employees"
            });

            var structure = [
                {field: 'id', name: 'id'},
                {field: 'lastName', name: 'Last Name'},
                {field: 'firstName', name: 'First Name'},
                {field: 'patronymicName', name: 'Patronymic Name'},
                {field: 'workPosition', name: 'Work Position'}
            ];

            var grid = new Grid({
                store: dataStore = new ObjectStore({objectStore: myStore}),
                style: "height: 500px",
                cacheClass: Async,
                structure: structure,
                modules: [
                    SingleSort,
                    Resizer
                ],
                modelExtensions: [
                    FormatSort
                ],
                onRowDblClick: lang.hitch(this, function (evt) {

                    var idx = evt.rowId;
                    var person = grid.row(idx).item();

                    var container = registry.byId(tabContainerNode);
                    var newTab = new TabFactory(person);

                    container.addChild(newTab);
                })
            });

            this.grid = grid;

            return grid;
        },

        _createAddBtn: function () {
            var addBtn = new Button({
                label: "Add",
                onClick: function () {
                    var container = registry.byId(tabContainerNode);
                    var tab = new TabFactory();
                    

                    container.addChild(tab);
                }
            });

            return addBtn;
        },

        _createRefreshBtn: function () {
            var refreshBtn = new Button({
                label: 'Refresh',
                onClick: function () {

                }
            });

            return refreshBtn;
        }
    })
});
