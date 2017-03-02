define([
    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/on",
    "dojo/json",
    "dojo/Deferred",
    "dijit/layout/ContentPane",
    "dojox/layout/TableContainer",
    "dijit/form/ValidationTextBox",
    "dijit/form/Button",
    "dijit/form/Form",
    "dijit/registry"
], function(
    declare,
    lang,
    on,
    JSON,
    Deferred,
    ContentPane,
    TableContainer,
    TextBox,
    Button,
    Form,
    registry
){
    return declare("TabFactory", [ContentPane], {
        last_name: null,
        first_name: null,
        patronymic_name: null,
        work_position: null,

        person: null,

        btnPane: null,

        saveBtn: null,
        
        constructor: function (person) {
            this.person = person;
        },

        postMixInProperties: function () {
            if (this.person == null) {
                var title = "Add new Employee";
            } else {
                title = this.person.lastName + " " + this.person.firstName.toUpperCase().charAt(0)
                    + ". " + this.person.patronymicName.toUpperCase().charAt(0);
            }
            this.inherited(arguments);
            this.title = title;
            this.region = 'center';
            this.closable = true;
        },

        postCreate: function() {
            this.addChild(this._createTableContainer());
            this.addChild(this._createButtons());
        },

        _createTableContainer: function () {
            var container = new TableContainer({
                labelWidth:'100%',
                style: 'width: 25%; border: 1px solid grey; border-radius: 4px'
            });
            
            this._createFields();

            container.addChild(this.last_name);
            container.addChild(this.first_name);
            container.addChild(this.patronymic_name);
            container.addChild(this.work_position);

            return container;
        },

        _createForm: function () {
            var form = new Form({
                
            });
        },

        _createFields: function () {
            var last_name = new TextBox({
                title: "Last Name:",
                value: this.person == null ? "" : this.person.lastName,
                placeHolder: "Write your Last Name here",
                pattern: "[a-zA-Z]{1,16}",
                required: true,
                missingMessage: "Not NULL",
                invalidMessage: "max length > 16",
                onKeyPress: lang.hitch(this, function (event) {
                    this._isFieldValid();
                })
            });
            
            var first_name = new TextBox({
                title: "First Name:",
                value: this.person == null ? "" : this.person.firstName,
                placeHolder: "Write your First Name here",
                pattern: "[a-zA-Z]{1,16}",
                required: true,
                missingMessage: "Not NULL",
                invalidMessage: "max length > 16",
                onKeyPress: lang.hitch(this, function (event) {
                    this._isFieldValid();
                })
            });
            
            var patronymic_name = new TextBox({
                title: "Patronymic Name: ",
                value: this.person == null ? "" : this.person.patronymicName,
                placeHolder: "Write your Patronymic Name here",
                pattern: "[a-zA-Z]{1,16}",
                required: true,
                missingMessage: "Not NULL",
                invalidMessage: "max length > 16",
                onKeyPress: lang.hitch(this, function (event) {
                    this._isFieldValid();
                })
            });

            var work_position = new TextBox({
                title: "Work position:",
                value: this.person == null ? "" : this.person.workPosition,
                placeHolder: "Write your Work Position here",
                pattern: "[a-zA-Z]{1,16}",
                required: true,
                missingMessage: "Not NULL",
                invalidMessage: "max length > 16",
                onKeyPress: lang.hitch(this, function (event) {
                    this._isFieldValid();
                })
            });
            
            this.last_name = last_name;
            this.first_name = first_name;
            this.patronymic_name = patronymic_name;
            this.work_position = work_position;
        },

        _isFieldValid: function () {
            if (this.last_name.isValid() && this.first_name.isValid() && this.patronymic_name.isValid() && this.work_position.isValid()) {
                this.saveBtn.set("disabled", false);
            } else {
                this.saveBtn.set("disabled", true);
            }
        },

        _createButtons: function () {
            var pane = new ContentPane({});

            pane.addChild(this._createSaveBtn());
            pane.addChild(this._createCancelBtn());
            if (this.person != null) {
                pane.addChild(this._createDeleteBtn());
            }

            this.btnPane = pane;

            return pane;
        },

        _createSaveBtn: function () {
            var person = null;

            if (this.person == null) {
                person = {lastName: null, firstName: null, patronymicName: null, workPosition: null}
            } else {
                person = this.person;
            }

            var save = new Button({
                label: "Save",
                onClick: lang.hitch(this, function () {

                    person.lastName = this.last_name.value;
                    person.firstName = this.first_name.value;
                    person.patronymicName = this.patronymic_name.value;
                    person.workPosition = this.work_position.value;

                    var xhrArgs = {
                        url: "/dojoWebApp/api/ecm/edit",
                        postData: JSON.stringify(person),

                        load: lang.hitch(this, function (response) {
                            var container = registry.byId(tabContainerNode);
                            container.removeChild(this);
                            this.destroy();
                        })
                    };
                    
                    dojo.xhrPost(xhrArgs);
                })
            });

            this.saveBtn = save;

            return save;
        },

        _createCancelBtn: function () {
            var cancel = new Button({
                label: "Cancel",
                onClick: lang.hitch(this, function () {
                    var container = registry.byId(tabContainerNode);
                    container.removeChild(this);
                    this.destroy();
                })
            });

            return cancel;
        },


        _createDeleteBtn: function () {
            var oldPerson = this.person;

            var remove = new Button({
                label: "Delete",
                onClick: lang.hitch(this, function () {

                    var xhrArgs = {
                        url: "/dojoWebApp/api/ecm/delete",
                        postData: JSON.stringify(oldPerson),

                        load: lang.hitch(this, function () {
                            var container = registry.byId(tabContainerNode);
                            container.removeChild(this);
                            this.destroy();
                        })
                    };

                    dojo.xhrPost(xhrArgs);
                })

            });

            return remove;
        }

    })
});
