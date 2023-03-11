export function ForgotPassword() {
    return (
        <>
            <div>
                <h2>Forgot Password</h2>
            </div>
            <form action="/forgot_password" method="post" >
                <div class="border border-secondary rounded p-3">
                    <div>
                        <p>We will be sending a reset password link to your email.</p>
                    </div>
                    <div>
                        <p>
                            <input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus />
                        </p>
                        <p class="text-center">
                            <input type="submit" value="Send" class="btn btn-primary" />
                        </p>
                    </div>
                </div>
            </form>
        </>
    )
}

