package demoapp

class AttendeeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [attendeeInstanceList: Attendee.list(params), attendeeInstanceTotal: Attendee.count()]
    }

    def create = {
        def attendeeInstance = new Attendee()
        attendeeInstance.properties = params
        return [attendeeInstance: attendeeInstance]
    }

    def save = {
        def attendeeInstance = new Attendee(params)
        if (attendeeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendeeInstance.id])}"
            redirect(action: "show", id: attendeeInstance.id)
        }
        else {
            render(view: "create", model: [attendeeInstance: attendeeInstance])
        }
    }

    def show = {
        def attendeeInstance = Attendee.get(params.id)
        if (!attendeeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
            redirect(action: "list")
        }
        else {
            [attendeeInstance: attendeeInstance]
        }
    }

    def edit = {
        def attendeeInstance = Attendee.get(params.id)
        if (!attendeeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [attendeeInstance: attendeeInstance]
        }
    }

    def update = {
        def attendeeInstance = Attendee.get(params.id)
        if (attendeeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (attendeeInstance.version > version) {
                    
                    attendeeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'attendee.label', default: 'Attendee')] as Object[], "Another user has updated this Attendee while you were editing")
                    render(view: "edit", model: [attendeeInstance: attendeeInstance])
                    return
                }
            }
            attendeeInstance.properties = params
            if (!attendeeInstance.hasErrors() && attendeeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendeeInstance.id])}"
                redirect(action: "show", id: attendeeInstance.id)
            }
            else {
                render(view: "edit", model: [attendeeInstance: attendeeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def attendeeInstance = Attendee.get(params.id)
        if (attendeeInstance) {
            try {
                attendeeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])}"
            redirect(action: "list")
        }
    }
}
